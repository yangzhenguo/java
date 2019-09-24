package com.yangzg.dao.inf;

import com.yangzg.model.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Sam on 2019/9/20.
 */
public interface ProductDao extends BaseDao<Product> {
    List<Product> selectAll() throws SQLException;

    boolean deleteById(int id) throws SQLException;
}
