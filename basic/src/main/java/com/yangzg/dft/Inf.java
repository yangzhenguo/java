package com.yangzg.dft;

/**
 * Created by Sam on 2019/9/5.
 */
public interface Inf {
    default String getName() {
        return "haha";
    }

    static void info() {
        System.out.println("Info");
    }
}
