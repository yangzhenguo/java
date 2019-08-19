package com.hiyzg.simple_factory.pizza;

/**
 * Created by Sam on 2019/8/19.
 */
public abstract class Pizza {
    abstract void prepare();
    void make () {
        System.out.println("maked");
    }
}
