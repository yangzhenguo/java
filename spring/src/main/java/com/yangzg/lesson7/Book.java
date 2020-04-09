package com.yangzg.lesson7;

/**
 * @author Sam
 * @date 2020/3/29 2:58 PM
 */
public class Book implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("closed");
    }
}
