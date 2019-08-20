package com.hiyzg.simple_factory.order;

import com.hiyzg.simple_factory.pizza.BJChessePizza;
import com.hiyzg.simple_factory.pizza.Pizza;

/**
 * Created by Sam on 2019/8/19.
 */
public class ChesseOrder extends Order {
    @Override
    Pizza get(String type) {
        if ("bj".equalsIgnoreCase(type)) {
            return new BJChessePizza();
        } else {
            return null;
        }
    }
}
