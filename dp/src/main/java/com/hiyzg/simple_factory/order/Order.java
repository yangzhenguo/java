package com.hiyzg.simple_factory.order;

import com.hiyzg.simple_factory.pizza.Pizza;

/**
 * Created by Sam on 2019/8/19.
 */
public abstract class Order {
    abstract Pizza get(String type);
}
