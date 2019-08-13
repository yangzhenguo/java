package com.hiyzg.singleton;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Sam on 2019/8/13.
 */
public class SingletonType4Test {
    @Test
    public void getInstance() throws Exception {
        SingletonType4 instance1 = SingletonType4.getInstance();
        SingletonType4 instance2 = SingletonType4.getInstance();
        Assert.assertTrue(instance1 == instance2);
    }

}