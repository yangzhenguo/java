package com.yangzg.model1;

import com.yangzg.service1.PersonService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.MessageFormat;

/**
 * Created by Sam on 2019/10/30.
 */
public class HelloWorldTest {
    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        final Person person = applicationContext.getBean(Person.class);
        System.out.println(person);
    }

    @Test
    public void test2() {
        try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            System.out.println(applicationContext.getBean("calendar"));
        }
    }

    @Test
    public void test3() {
        try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml")) {
//            System.out.println(applicationContext.getBean("dataSource1"));
//            System.out.println(applicationContext.getBean("dataSource2"));
//            System.out.println(applicationContext.getBean("dataSource3"));
            System.out.println(applicationContext.getBean("dataSource4"));
        }
    }

    @Test
    public void test4() {
        try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            final String helloWorld1 = applicationContext.getBean("helloWorld", String.class);
            final String helloWorld2 = applicationContext.getBean("helloWorld", String.class);
            System.out.println(helloWorld1 == helloWorld2);
            System.out.println(helloWorld1);
            System.out.println(MessageFormat.format("{0} is a Chinese {1}", "yangzg", "worker"));
        }
    }

    @Test
    public void test5() {
        try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            final Object person1 = applicationContext.getBean("person1");
            final Object person2 = applicationContext.getBean("person1");
            System.out.println(person1);
            System.out.println(person2);
            System.out.println(person1 == person2);
            final Object bean = applicationContext.getBean("&person1");
            System.out.println(bean);
        }
    }

    @Test
    public void test6() {
        try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            final PersonService personService = applicationContext.getBean("personService", PersonService.class);
            System.out.println(personService);
        }
    }
}