package com.yangzg.beans;

import com.yangzg.beans3.Factories;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

/**
 * Created by Sam on 2019/11/14.
 */
public class LookupTest {
    @Test
    public void test1() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans8.xml")) {
            final Factories factories = context.getBean(Factories.class);
            factories.getUser().say();
            factories.getObjects().forEach((key, value) -> System.out.println(String.format("%s -> %s", key, value)));
        }
    }

    @Test
    public void test2() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans8.xml")) {
            final Calendar timerFactory = context.getBean("timerFactory", Calendar.class);
            System.out.println(timerFactory.getTimeZone());
        }
    }
}
