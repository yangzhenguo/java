package com.hiyzg.shop.service.impl;

import com.hiyzg.shop.criteria.BookCriteria;
import com.hiyzg.shop.dao.BookDao;
import com.hiyzg.shop.dao.impl.BookDaoImpl;
import com.hiyzg.shop.model.Book;
import com.hiyzg.shop.service.BookService;
import com.hiyzg.shop.util.ShopCart;
import com.hiyzg.util.Page;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/10/14.
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

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
}
