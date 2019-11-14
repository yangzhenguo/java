package com.yangzg.beans;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sam on 2019/11/14.
 */
public class DependsOnTest {
    @Test
    public void test1() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans6.xml")) {
            final Student student = context.getBean(Student.class);
            System.out.println(student);
        }
    }
}
