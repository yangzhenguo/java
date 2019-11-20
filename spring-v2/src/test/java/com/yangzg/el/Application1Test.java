package com.yangzg.el;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Sam on 2019/11/20.
 */
public class Application1Test {
    @Test
    public void test1() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application1.class)) {
            final Application1 application1 = context.getBean(Application1.class);
            System.out.println(application1.names);

            System.out.println(application1.nameList);

            System.out.println(application1.environs);
        }
    }
}