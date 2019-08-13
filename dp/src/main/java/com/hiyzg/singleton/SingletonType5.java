package com.hiyzg.singleton;

/**
 * Created by Sam on 2019/8/13.
 */
public class SingletonType5 {
    private static volatile SingletonType5 INSTANCE;

    private SingletonType5() {}

    public static SingletonType5 getInstance() {
        if (INSTANCE != null) {
            synchronized (SingletonType5.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonType5();
                }
            }
        }
        return INSTANCE;
    }
}
