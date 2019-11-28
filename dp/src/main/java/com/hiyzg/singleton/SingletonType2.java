package com.hiyzg.singleton;

/**
 * Created by Sam on 2019/8/13.
 */
public class SingletonType2 {
    private static final SingletonType2 INSTANCE;

    static {
        INSTANCE = new SingletonType2();
    }

    private SingletonType2() {}

    public static SingletonType2 getInstance() {
        return INSTANCE;
    }
}
