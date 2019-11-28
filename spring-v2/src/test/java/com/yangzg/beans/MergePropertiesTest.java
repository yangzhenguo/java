package com.yangzg.beans;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sam on 2019/11/14.
 */
public class MergePropertiesTest {
    @Test
    public void test1() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans/beans4.xml")) {
            final MergeProperties mergeProperties = context.getBean("newProperties", MergeProperties.class);
            System.out.println(mergeProperties);
        }
    }

    @Test
    public void test2() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans/beans4.xml")) {
            final ShopPrices beijingShop = context.getBean("beijingShop", ShopPrices.class);
            System.out.println(beijingShop);
        }
    }
}
