package com.hiyzg.singleton;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Sam on 2019/8/13.
 */
public class SingletonType3Test {
    @Test
    public void getInstance() throws Exception {
        SingletonType3 instance1 = SingletonType3.getInstance();
        SingletonType3 instance2 = SingletonType3.getInstance();
        assertTrue(instance1 == instance2);
    }

}