package com.yangzg.annotation2.controller;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by Sam on 2019/11/18.
 */
public class UserControllerTest {
    @Test
    public void execute() throws Exception {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation2/beans.xml")) {
            final UserController userController = context.getBean(UserController.class);
            userController.execute();

//            final UserService userService = context.getBean(UserService.class);
//            userService.add();

            System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        }
    }
}