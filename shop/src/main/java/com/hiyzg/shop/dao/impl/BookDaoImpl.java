package com.hiyzg.shop.dao.impl;

import com.hiyzg.shop.criteria.BookCriteria;
import com.hiyzg.shop.dao.BookDao;
import com.hiyzg.shop.model.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sam on 2019/10/11.
 */
public class BookDaoImpl extends BaseDao<Book> implements BookDao {
    @Override
    protected Map<String, String> getColumnToPropertyOverrides() {
        return new HashMap<String, String>(){
            private static final long serialVersionUID = 1L;

            {
                put("publishing_date", "publishingDate");
                put("sales_amount", "salesAmount");
                put("store_number", "storeNumber");
            }
        };
    }

    @Override
    public long count(BookCriteria criteria) {
        final String sql = "select count(*) from book where price >= ? and price <= ?";
        return this.count(sql, criteria.getMinPrice(), criteria.getMaxPrice());
    }

    @Override
    public List<Book> getList(BookCriteria criteria) {
        final String sql = "select * from book where price >= ? and price <= ? limit ?, ?";
        return this.list(sql, criteria.getMinPrice(), criteria.getMaxPrice(), (criteria.getPage() - 1) * criteria.getSize(), criteria.getSize());
    }
}
