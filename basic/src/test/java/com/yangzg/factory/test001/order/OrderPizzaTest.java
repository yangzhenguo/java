package com.yangzg.factory.test001.order;

import org.junit.Test;

/**
 * Created by Sam on 2020/2/22.
 */
public class OrderPizzaTest {
    @Test
    public void testOrder() throws Exception {
        System.out.println(SimpleFactory.create("chess"));
    }
}