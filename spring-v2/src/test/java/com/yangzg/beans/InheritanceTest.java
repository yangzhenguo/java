package com.yangzg.beans;

import com.yangzg.beans3.Template;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by Sam on 2019/11/15.
 */
public class InheritanceTest {
    @Test
    public void test1() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans/beans12.xml")) {
            final Template template = context.getBean("bean", Template.class);
            System.out.println(template);

            System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        }
    }
}
