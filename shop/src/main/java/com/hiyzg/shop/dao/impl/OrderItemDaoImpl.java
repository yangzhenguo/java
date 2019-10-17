package com.hiyzg.shop.dao.impl;

import com.hiyzg.shop.dao.OrderItemDao;
import com.hiyzg.shop.model.OrderItem;
import com.hiyzg.shop.util.ConnectionContext;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sam on 2019/10/17.
 */
public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {
    @Override
    public OrderItem insert(OrderItem orderItem) {
        final String sql = "INSERT INTO order_item(order_id, name, unit_price, price, count, `date`) VALUES(?, ?, ?, ?, ?, ?)";
        orderItem.setId(this.insert(sql, orderItem.getOrderId(), orderItem.getName(), orderItem.getUnitPrice(), orderItem.getPrice(), orderItem.getCount(), orderItem.getDate()));
        return orderItem;
    }

    @Override
    protected Map<String, String> getColumnToPropertyOverrides() {
        return new HashMap<String, String>(){
            private static final long serialVersionUID = 1L;
            {
                put("unit_price", "unitPrice");
                put("order_id", "orderId");
            }
        };
    }

    @Override
    public void insert(List<OrderItem> orderItems) {
        final String sql = "INSERT INTO order_item(order_id, name, unit_price, price, count, `date`) VALUES(?, ?, ?, ?, ?, ?)";
        final Object[][] params = orderItems.stream().map(orderItem -> new Object[]{orderItem.getOrderId(), orderItem.getName(), orderItem.getUnitPrice(), orderItem.getPrice(), orderItem.getCount(), new Timestamp(orderItem.getDate().getTime())}).toArray(Object[][]::new);
        try {
            final List<Map<String, Object>> maps = this.queryRunner.insertBatch(ConnectionContext.getInstance().get(), sql, new MapListHandler(), params);
            System.out.println(maps);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
