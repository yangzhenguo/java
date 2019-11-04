package com.yangzg.config4;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Sam on 2019/11/2.
 */
public class ApplicationTest {
    @Test
    public void test1() {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class)) {

        }
    }
}
