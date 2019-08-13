package com.hiyzg.singleton;

/**
 * Created by Sam on 2019/8/13.
 */
public class SingletonType3 {
    private static SingletonType3 INSTANCE;

    private SingletonType3() {}

    public static SingletonType3 getInstance() {
        if (INSTANCE != null) {
            INSTANCE = new SingletonType3();
        }
        return INSTANCE;
    }
}
