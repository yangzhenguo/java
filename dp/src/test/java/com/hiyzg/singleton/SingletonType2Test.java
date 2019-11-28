package com.hiyzg.singleton;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Sam on 2019/8/13.
 */
public class SingletonType2Test {
    @Test
    public void getInstance() throws Exception {
        SingletonType2 instance1 = SingletonType2.getInstance();
        SingletonType2 instance2 = SingletonType2.getInstance();

        assertTrue(instance1 == instance2);
    }

}