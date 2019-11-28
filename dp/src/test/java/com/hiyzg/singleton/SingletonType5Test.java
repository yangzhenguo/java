package com.hiyzg.singleton;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Sam on 2019/8/13.
 */
public class SingletonType5Test {
    @Test
    public void getInstance() throws Exception {
        SingletonType5 instance1 = SingletonType5.getInstance();
        SingletonType5 instance2 = SingletonType5.getInstance();
        Assert.assertTrue(instance1 == instance2);
    }

}