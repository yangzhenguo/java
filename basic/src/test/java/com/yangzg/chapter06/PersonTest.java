package com.yangzg.chapter06;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sam on 2019/6/17.
 */
public class PersonTest {
    @Test
    public void test1() {
        Person sam = new Person("sam", 21);
        System.out.println(sam);
    }

}