package com.hiyzg.singleton;

/**
 * Created by Sam on 2019/8/13.
 */
public class SingletonType6 {
    private SingletonType6() {}

    public static SingletonType6 getInstance() {
        return Inner.INSTANCE;
    }

    private static class Inner {
        private static final SingletonType6 INSTANCE = new SingletonType6();
    }
}
