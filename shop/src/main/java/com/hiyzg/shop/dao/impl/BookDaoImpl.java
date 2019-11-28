package com.hiyzg.shop.dao.impl;

import com.hiyzg.shop.criteria.BookCriteria;
import com.hiyzg.shop.dao.BookDao;
import com.hiyzg.shop.model.Book;
import com.hiyzg.shop.util.ConnectionContext;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        final String sql = "SELECT COUNT(*) FROM book WHERE price >= ? AND price <= ?";
        return this.count(sql, criteria.getMinPrice(), criteria.getMaxPrice());
    }

    @Override
    public List<Book> getList(BookCriteria criteria) {
        final String sql = "SELECT * FROM book WHERE price >= ? AND price <= ? LIMIT ?, ?";
        return this.list(sql, criteria.getMinPrice(), criteria.getMaxPrice(), (criteria.getPage() - 1) * criteria.getSize(), criteria.getSize());
    }

    @Override
    public Optional<Book> selectById(long id) {
        final String sql = "SELECT * FROM book WHERE id = ?";
        return this.selectById(sql, id);
    }

    @Override
    public void batchUpdateSalesAndStoreAmount(Object[][] params) {
        final String sql = "UPDATE book SET sales_amount = sales_amount + ?, store_number = store_number - ? WHERE id = ?";
        try {
            this.queryRunner.batch(ConnectionContext.getInstance().get(), sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
