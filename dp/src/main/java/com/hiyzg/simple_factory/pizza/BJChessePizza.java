package com.hiyzg.simple_factory.pizza;

/**
 * Created by Sam on 2019/8/19.
 */
public class BJChessePizza extends Pizza {
    @Override
    void prepare() {
        System.out.println("准备bj奶酪披萨");
    }
}
