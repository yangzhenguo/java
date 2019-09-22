package com.yangzg.service.inf;

import com.yangzg.model.Product;

import java.util.List;

/**
 * Created by Sam on 2019/9/20.
 */
public interface ProductService {
    List<Product> listAll();

    boolean remove(int id);
}
