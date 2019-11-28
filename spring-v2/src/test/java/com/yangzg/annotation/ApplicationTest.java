package com.yangzg.annotation;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by Sam on 2019/11/17.
 */
public class ApplicationTest {
    @Test
    public void test1() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("core/beans1.xml")) {
            System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
            final Application application = context.getBean(Application.class);
            application.getStringOptional().ifPresent(System.out::println);

            System.out.println(application.getObjects());

            application.getApplicationContextOptional().ifPresent(System.out::println);

            System.out.println(application.getEncoding());

            System.out.println(application.getSysProperties());

            System.out.println(application.getSystemEnvironment());

            System.out.println(application.getPython());

            System.out.println(application.getRuntimeName());

            final Properties properties = context.getBean(Properties.class);
            System.out.println(properties);

            System.out.println(Arrays.toString(application.getName()));

            System.out.println(application.getStudent());
        }
    }
}