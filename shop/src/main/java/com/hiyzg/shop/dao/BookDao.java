package com.hiyzg.shop.dao;

import com.hiyzg.shop.criteria.BookCriteria;
import com.hiyzg.shop.model.Book;

import java.util.List;

/**
 * Created by Sam on 2019/10/11.
 */
public interface BookDao extends Dao<Book> {
    long count(BookCriteria criteria);

    List<Book> getList(BookCriteria criteria);
}
