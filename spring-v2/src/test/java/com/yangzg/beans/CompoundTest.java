package com.yangzg.beans;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sam on 2019/11/14.
 */
public class CompoundTest {
    @Test
    public void test1() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans/beans5.xml")) {
            final Classroom classroom = context.getBean("classroom", Classroom.class);
            System.out.println(classroom);
        }
    }
}
