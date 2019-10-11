package com.hiyzg.shop.dao.impl;

import com.hiyzg.shop.dao.BookDao;
import com.hiyzg.shop.model.Book;

import java.util.HashMap;
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
                put("sales_amount", "salesAmount");
            }
        };
    }
}
