package com.yangzg.spring.chapter01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.StringReader;

/**
 * Created by Sam on 2019/6/18.
 */
@Configuration
@ComponentScan("com.yangzg.spring.chapter01")
public class DiConfig {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DiConfig.class)) {
            UseFunctionService useFunctionService = applicationContext.getBean(UseFunctionService.class);
            new BufferedReader(new StringReader(useFunctionService.sayHello("world"))).lines().forEach(System.out::println);
        }
    }
}
