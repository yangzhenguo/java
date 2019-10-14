package com.hiyzg.shop.service.impl;

import com.hiyzg.shop.criteria.BookCriteria;
import com.hiyzg.shop.dao.BookDao;
import com.hiyzg.shop.dao.impl.BookDaoImpl;
import com.hiyzg.shop.model.Book;
import com.hiyzg.shop.service.BookService;
import com.hiyzg.util.Page;

import java.util.List;

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
}
