package com.yangzg.beans;

import com.yangzg.beans2.Teacher;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sam on 2019/11/14.
 */
public class AutowireTest {
    @Test
    public void test1() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans7.xml")) {
            final Teacher teacher = context.getBean("teacher", Teacher.class);
            System.out.println(teacher);

            teacher.getObjects().forEach((key, value) -> System.out.println(String.format("%s -> %s", key, value)));
        }
    }
}
