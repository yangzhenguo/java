package com.hiyzg.singleton;

/**
 * Created by Sam on 2019/8/13.
 */
public class SingletonType7 {
    public static void main(String[] args) {
        System.out.println(Singleton.INSTANCE.hashCode());
        System.out.println(Singleton.INSTANCE.hashCode());
    }
}

enum Singleton {
    INSTANCE();
}