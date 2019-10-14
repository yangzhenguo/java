package com.hiyzg.shop.dao.impl;

import com.hiyzg.shop.criteria.BookCriteria;
import com.hiyzg.shop.dao.BookDao;
import com.hiyzg.shop.model.Book;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by Sam on 2019/10/11.
 */
public class BookDaoImplTest {
    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void clazz() {
        System.out.println(new BookDaoImpl().getClazz());
    }

    @Test
    public void insert() {
        final long id = bookDao.insert("INSERT INTO book(name) VALUES(?)", "yzg");
        System.out.println(id);
        assertTrue(id > 0);
    }

    @Test
    public void selectById() {
        final Optional<Book> bookOptional = this.bookDao.selectById("SELECT * FROM book WHERE id = ?", 1);
        bookOptional.ifPresent(System.out::println);
        assertTrue(bookOptional.isPresent());
    }

    @Test
    public void count() {
        final BookCriteria criteria = new BookCriteria(1);
        final long count = this.bookDao.count(criteria);
        System.out.println(count);
    }

    @Test
    public void getList() {
        final BookCriteria criteria = new BookCriteria(1);
        final List<Book> books = this.bookDao.getList(criteria);
        System.out.println(books);
    }
}