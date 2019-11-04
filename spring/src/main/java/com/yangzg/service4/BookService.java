package com.yangzg.service4;

import com.yangzg.dao4.BookDao;
import com.yangzg.model4.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Sam on 2019/11/2.
 */
@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public void decreaseStock(final String name) {
        this.bookDao.decreaseStock(name);
    }

    public Optional<Book> selectByName(final String name) {
        return this.bookDao.selectByName(name);
    }
}
