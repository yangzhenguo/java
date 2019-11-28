package com.yangzg.chapter05;

import java.util.Date;

/**
 * Created by Sam on 2019/6/17.
 */
public interface MyInterface {
    void func();

    static MyInterface of() {
        return () -> System.out.println("haha");
    }

    static void haha() {
        System.out.println(new Date());
    }

    static void main(String[] args) {
        haha();

        MyInterface.of().func();
    }
}
