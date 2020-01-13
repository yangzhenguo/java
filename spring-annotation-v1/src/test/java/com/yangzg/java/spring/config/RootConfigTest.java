package com.yangzg.java.spring.config;

import com.yangzg.java.spring.model.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * Created by Sam on 2020/1/11.
 */
public class RootConfigTest {
    @Test
    public void test1() throws Exception {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfig.class)) {
            Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
            final Person person1 = applicationContext.getBean(Person.class);
            final Person person2 = applicationContext.getBean(Person.class);
            System.out.println(person1 == person2);
        }
    }

    @Test
    public void test2() throws Exception {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfig.class)) {
        }
    }
}