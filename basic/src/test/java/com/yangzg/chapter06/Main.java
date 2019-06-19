package com.yangzg.chapter06;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sam on 2019/6/17.
 */
public class Main {
    @Test
    public void test1() {
        Fu fu = new Zi();
        System.out.println(fu.a);
        assertEquals(1, fu.a);
    }
}