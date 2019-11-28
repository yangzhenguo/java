package com.hiyzg.singleton;

/**
 * Created by Sam on 2019/8/13.
 */
public class SingletonType1 {
    private static final SingletonType1 INSTANCE = new SingletonType1();

    // private constructor
    private SingletonType1() {}

    // getter
    public static SingletonType1 getInstance() {
        return INSTANCE;
    }
}
