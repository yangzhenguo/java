package com.hiyzg.shop.service.impl;

import com.hiyzg.shop.criteria.BookCriteria;
import com.hiyzg.shop.model.Book;
import com.hiyzg.shop.service.BookService;
import com.hiyzg.util.Page;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by Sam on 2019/10/14.
 */
public class BookServiceImplTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void listForPager() throws Exception {
        final BookCriteria criteria = new BookCriteria(1);
        final Page<Book> bookPage = bookService.listForPager(criteria);
        System.out.println(bookPage);
    }

    @Test
    public void getById() {
        final Optional<Book> bookOptional = this.bookService.getById(1);
        assertTrue(bookOptional.isPresent());
    }
}