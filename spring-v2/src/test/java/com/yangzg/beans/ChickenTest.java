package com.yangzg.beans;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sam on 2019/11/14.
 */
public class ChickenTest {
    @Test
    public void test1() {
        try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans/chicken-egg.xml")) {
            final Chicken chicken = applicationContext.getBean("chicken", Chicken.class);
            System.out.println(chicken);
        }
    }
}