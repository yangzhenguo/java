package com.hiyzg.shop.service;

import com.hiyzg.shop.criteria.BookCriteria;
import com.hiyzg.shop.model.Book;
import com.hiyzg.util.Page;

/**
 * Created by Sam on 2019/10/14.
 */
public interface BookService {
    Page<Book> listForPager(BookCriteria criteria);
}
