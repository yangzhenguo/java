package com.hiyzg.singleton;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Sam on 2019/8/13.
 */
public class SingletonType7 {
    public static void main(String[] args) {
        System.out.println(Singleton.INSTANCE.hashCode());
        System.out.println(Singleton.INSTANCE.hashCode());

        new BufferedReader(new InputStreamReader(System.in)).lines().forEach(System.out::println);
    }
}

enum Singleton {
    INSTANCE();
}