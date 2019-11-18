package com.yangzg.annotation3;

import com.yangzg.annotation3.controller.UserController;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by Sam on 2019/11/18.
 */
public class ApplicationTest {
    @Test
    public void test1() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class)) {
            final UserController userController = context.getBean(UserController.class);
            userController.execute();
        }
    }

    @Test
    public void test2() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation2/beans2.xml")) {
            System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
            final UserController userController = context.getBean(UserController.class);
            userController.execute();
        }
    }
}