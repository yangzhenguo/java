package com.yangzg.beans;

import com.yangzg.beans3.Company;
import com.yangzg.beans3.Company2;
import com.yangzg.beans3.Factories;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Calendar;
import java.util.stream.IntStream;

/**
 * Created by Sam on 2019/11/14.
 */
public class LookupTest {
    @Test
    public void test1() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans/beans8.xml")) {
            final Factories factories = context.getBean(Factories.class);
            factories.getUser().say();
            factories.getObjects().forEach((key, value) -> System.out.println(String.format("%s -> %s", key, value)));
        }
    }

    @Test
    public void test2() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans/beans8.xml")) {
            final Calendar timerFactory = context.getBean("timerFactory", Calendar.class);
            System.out.println(timerFactory.getTimeZone());
        }
    }

    @Test
    public void test3() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans/beans9.xml")) {
            final Company company = context.getBean(Company.class);
            System.out.println(company.getEmployee());
            IntStream.rangeClosed(1, 10).forEach(i -> System.out.println(company.getEmployee()));
        }
    }

    @Test
    public void test4() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans/beans10.xml")) {
            final Company2 company = context.getBean(Company2.class);
            IntStream.rangeClosed(1, 1).forEach(i -> System.out.println(company.getEmployee()));

            System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        }
    }
}
