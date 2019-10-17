package com.hiyzg.shop.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by Sam on 2019/10/17.
 */
@Data
public class OrderItem {
    private long id;
    private long orderId;
    private String name;
    private double unitPrice;
    private double price;
    private int count;
    private Date date;

    public OrderItem(long orderId, String name, double unitPrice, double price, int count, Date date) {
        this.orderId = orderId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.price = price;
        this.count = count;
        this.date = date;
    }
}
