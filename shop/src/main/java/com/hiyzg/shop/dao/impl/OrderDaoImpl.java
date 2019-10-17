package com.hiyzg.shop.dao.impl;

import com.hiyzg.shop.dao.OrderDao;
import com.hiyzg.shop.model.Order;

import java.sql.Timestamp;

/**
 * Created by Sam on 2019/10/17.
 */
public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {
    @Override
    public Order insert(Order order) {
        final String sql = "INSERT INTO `order`(price, `date`) VALUES(?, ?)";
        order.setId(this.insert(sql, order.getPrice(), new Timestamp(order.getDate().getTime())));
        return order;
    }
}
