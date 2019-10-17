package com.hiyzg.shop.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by Sam on 2019/10/17.
 */
@Data
public class Order {
    private long id;
    private double price;
    private Date date;

    public Order(double price, Date date) {
        this.price = price;
        this.date = date;
    }
}
