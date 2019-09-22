package com.yangzg.service.impl;

import com.yangzg.dao.impl.ProductDaoImpl;
import com.yangzg.dao.inf.ProductDao;
import com.yangzg.model.Product;
import com.yangzg.service.inf.ProductService;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sam on 2019/9/20.
 */
public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public List<Product> listAll() {
        try {
            return this.productDao.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public boolean remove(int id) {
        try {
            return this.productDao.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
