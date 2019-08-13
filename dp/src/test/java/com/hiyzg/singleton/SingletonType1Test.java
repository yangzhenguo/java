package com.hiyzg.singleton;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sam on 2019/8/13.
 */
public class SingletonType1Test {
    @Test
    public void getInstance() throws Exception {
        SingletonType1 instance1 = SingletonType1.getInstance();
        SingletonType1 instance2 = SingletonType1.getInstance();
        assertTrue(instance1 == instance2);

        System.out.println(String.format("hashcode=%s", instance1.hashCode()));
        System.out.println(String.format("hashcode=%s", instance2.hashCode()));
    }

}