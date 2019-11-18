package com.yangzg.beans;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by Sam on 2019/11/13.
 */
public class HelloWorldTest {
    @Test
    public void hello() throws Exception {
        try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans/beans.xml")) {
            final HelloWorld helloWorld = applicationContext.getBean("helloWorld", HelloWorld.class);

            System.out.println(helloWorld.hello());

            System.out.println(System.getProperties());

            final SpelExpressionParser expressionParser = new SpelExpressionParser();
            System.out.println(expressionParser.parseExpression("'Hello World'").getValue());
            System.out.println(expressionParser.parseExpression("#systemProperties").getValue());

            System.out.println(expressionParser.parseExpression("'Hello World'.concat('!')").getValue());
        }
    }

    @Test
    public void test1() {
        try (GenericApplicationContext applicationContext = new GenericApplicationContext()) {
            new XmlBeanDefinitionReader(applicationContext).loadBeanDefinitions("beans/beans.xml");
            applicationContext.refresh();
            System.out.println(applicationContext.isActive());

            applicationContext.getDefaultListableBeanFactory().registerSingleton("obj", new Object());
            System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
        }
    }

    @Test
    public void test2() {
        try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans/beans.xml")) {
            System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
//            applicationContext.refresh();
            final HelloWorld helloWorld = applicationContext.getBean("helloWorld", HelloWorld.class);
            final HelloWorld Hello = applicationContext.getBean("Hello", HelloWorld.class);
            final HelloWorld World = applicationContext.getBean("World", HelloWorld.class);
            System.out.println(helloWorld == Hello);
            System.out.println(helloWorld == World);
        }
    }

    @Test
    public void test3() {
        try (GenericApplicationContext applicationContext = new GenericApplicationContext()) {
            new XmlBeanDefinitionReader(applicationContext).loadBeanDefinitions("beans/beans.xml");
            applicationContext.refresh();
            System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
            final Calendar calender = applicationContext.getBean("calendar", Calendar.class);
            final Calendar calender2 = applicationContext.getBean("calendar2", Calendar.class);
            System.out.println(calender == calender2);

            System.out.println(calender.getTime().toLocaleString());
            System.out.println(calender.getTimeZone());
        }
    }

    @Test
    public void test4() {
        try (GenericApplicationContext applicationContext = new GenericApplicationContext()) {
            new XmlBeanDefinitionReader(applicationContext).loadBeanDefinitions("beans/beans.xml");
            applicationContext.refresh();
            System.out.println(applicationContext.getBean("helloWorld", HelloWorld.class));
        }
    }
}