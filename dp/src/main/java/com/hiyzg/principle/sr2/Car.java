package com.hiyzg.principle.sr2;

/**
 * Created by Sam on 2019/7/20.
 */
public class Car implements Vehicle {
    @Override
    public void run(String name) {
        System.out.println(String.format("%s是小汽车", name));
    }
}
