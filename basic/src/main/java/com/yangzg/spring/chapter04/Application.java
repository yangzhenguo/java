package com.yangzg.spring.chapter04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

/**
 * Created by Sam on 2019/6/19.
 */
@Configuration
@ComponentScan("com.yangzg.spring.chapter04")
@EnableScheduling
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);

        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
