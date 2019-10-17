package com.hiyzg.shop.service.impl;

import com.hiyzg.shop.criteria.BookCriteria;
import com.hiyzg.shop.dao.AccountDao;
import com.hiyzg.shop.dao.BookDao;
import com.hiyzg.shop.dao.OrderDao;
import com.hiyzg.shop.dao.OrderItemDao;
import com.hiyzg.shop.dao.impl.AccountDaoImpl;
import com.hiyzg.shop.dao.impl.BookDaoImpl;
import com.hiyzg.shop.dao.impl.OrderDaoImpl;
import com.hiyzg.shop.dao.impl.OrderItemDaoImpl;
import com.hiyzg.shop.model.*;
import com.hiyzg.shop.service.BookService;
import com.hiyzg.shop.util.ShopCart;
import com.hiyzg.util.Page;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Sam on 2019/10/14.
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    private AccountDao accountDao = new AccountDaoImpl();
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Override
    public Page<Book> listForPager(BookCriteria criteria) {
        long total = this.bookDao.count(criteria);
        List<Book> books = this.bookDao.getList(criteria);
        return new Page<>(books, criteria.getPage(), criteria.getSize(), total);
    }

    @Override
    public Optional<Book> getById(long id) {
        return this.bookDao.selectById(id);
    }

    @Override
    public void addToCart(long id, ShopCart shopCart) {
        final Optional<Book> bookOptional = this.getById(id);
        if (bookOptional.isPresent()) {
            this.addToCart(bookOptional.get(), shopCart);
        } else {
            throw new RuntimeException("图书不存在");
        }
    }

    @Override
    public void addToCart(Book book, ShopCart shopCart) {
        shopCart.add(book);
    }

    @Override
    public void deleteFromCart(int id, ShopCart shopCart) {
        shopCart.remove(id);
    }

    @Override
    public void changeCart(int id, int count, ShopCart shopCart) {
        shopCart.update(id, count);
    }

    @Override
    public void transact(User user, Account account, ShopCart shopCart) {
        // 增减库存
        this.bookDao.batchUpdateSalesAndStoreAmount(shopCart.getBooks().entrySet().stream().map(entry -> new Object[]{entry.getValue().getQuantity(), entry.getValue().getQuantity(), entry.getKey()}).toArray(Object[][]::new));

        // 扣除金额
        this.accountDao.updateBalance(account.getNo(), account.getBalance() - shopCart.getPrice());

        // 创建订单
        final Order order = new Order(shopCart.getPrice(), new Date());
        this.orderDao.insert(order);

        // 创建订单项
        this.orderItemDao.insert(shopCart.getBooks().values().stream().map(item -> new OrderItem(order.getId(), item.getBook().getTitle(), item.getBook().getPrice(), item.getPrice(), item.getQuantity(), new Date())).collect(Collectors.toList()));

        // 清空购物车
        shopCart.clear();
    }
}
