package com.hiyzg.shop.util;

import com.hiyzg.shop.model.Book;
import com.hiyzg.util.Page;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Sam on 2019/10/11.
 */
public class PageTest {
    private List<Book> books = new ArrayList<Book>(){
        private static final long serialVersionUID = 1L;

        {
            add(new Book(12L, "java"));
            add(new Book(15L, "Oracle"));
        }
    };

    @Test
    public void getPage() throws Exception {
        final Page<Book> page = new Page<>(books, 10);
        assertTrue(1 == page.getPage());
    }

    @Test
    public void getSize() throws Exception {
        final Page<Book> page = new Page<>(books, 10);
        assertTrue(5 == page.getSize());
    }

    @Test
    public void getTotal() throws Exception {
        final Page<Book> page = new Page<>(books, 10);
        assertTrue(10 == page.getTotal());
    }

    @Test
    public void getPages() throws Exception {
        final Page<Book> page = new Page<>(books, 10);
        assertTrue(page.getPages() == 2);
    }

    @Test
    public void hasNext() throws Exception {
        final Page<Book> page = new Page<>(books, 10);
        assertTrue(page.isHasNext());
    }

    @Test
    public void hasPrev() throws Exception {
        final Page<Book> page = new Page<>(books, 2, 10);
        assertTrue(page.isHasPrev());
    }

    @Test
    public void getPrevPage() throws Exception {
        final Page<Book> page = new Page<>(books, 10);
        assertTrue(page.getPrevPage() == 1);
    }

    @Test
    public void getNextPage() throws Exception {
        final Page<Book> page = new Page<>(books, 2, 10);
        assertTrue(page.getNextPage() == 2);
    }

}