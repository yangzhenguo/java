package com.hiyzg.singleton;

/**
 * Created by Sam on 2019/8/13.
 */
public class SingletonType4 {
    private static SingletonType4 INSTANCE;

    private SingletonType4() {}

    public synchronized static SingletonType4 getInstance() {
        if (INSTANCE != null) {
            INSTANCE = new SingletonType4();
        }
        return INSTANCE;
    }
}
