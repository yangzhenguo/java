package com.hiyzg.shop.dao;

import com.hiyzg.shop.criteria.BookCriteria;
import com.hiyzg.shop.model.Book;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/10/11.
 */
public interface BookDao extends Dao<Book> {
    long count(BookCriteria criteria);

    List<Book> getList(BookCriteria criteria);

    Optional<Book> selectById(final long id);

    void batchUpdateSalesAndStoreAmount(Object[][] params);
}
