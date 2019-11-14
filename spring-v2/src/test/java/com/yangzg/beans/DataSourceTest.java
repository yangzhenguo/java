package com.yangzg.beans;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sam on 2019/11/14.
 */
public class DataSourceTest {
    @Test
    public void test1() {
        try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans2.xml")) {
            final BasicDataSource dataSource1 = applicationContext.getBean("dataSource", BasicDataSource.class);
            final BasicDataSource dataSource2 = applicationContext.getBean("dataSource2", BasicDataSource.class);
            System.out.println(dataSource1);
            System.out.println(dataSource2);
        }
    }

    @Test
    public void test2() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml")) {
            final BasicDataSource dataSource3 = context.getBean("dataSource3", BasicDataSource.class);
            System.out.println(dataSource3);
            System.out.println(dataSource3.getUrl());
        }
    }
}
