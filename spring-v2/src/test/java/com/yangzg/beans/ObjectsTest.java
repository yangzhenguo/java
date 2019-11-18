package com.yangzg.beans;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sam on 2019/11/14.
 */
public class ObjectsTest {
    @Test
    public void test1() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans/beans3.xml")) {
            final Objects objects = context.getBean("objects", Objects.class);
            System.out.println(objects);
        }
    }
}
