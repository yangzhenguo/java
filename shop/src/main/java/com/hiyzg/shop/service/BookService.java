package com.hiyzg.shop.service;

import com.hiyzg.shop.criteria.BookCriteria;
import com.hiyzg.shop.model.Book;
import com.hiyzg.shop.util.ShopCart;
import com.hiyzg.util.Page;

import java.util.Optional;

/**
 * Created by Sam on 2019/10/14.
 */
public interface BookService {
    Page<Book> listForPager(BookCriteria criteria);

    Optional<Book> getById(final long id);

    void addToCart(long id, ShopCart shopCart);

    void addToCart(Book book, ShopCart shopCart);
}
