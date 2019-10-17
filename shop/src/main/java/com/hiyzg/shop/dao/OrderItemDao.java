package com.hiyzg.shop.dao;

import com.hiyzg.shop.model.OrderItem;

import java.util.List;

/**
 * Created by Sam on 2019/10/17.
 */
public interface OrderItemDao {
    OrderItem insert(OrderItem order);

    void insert(List<OrderItem> orderItems);
}
