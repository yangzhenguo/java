package com.yangzg.service2;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sam on 2019/10/31.
 */
public class AopTest {
    @Test
    public void test1() {
        try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-aop.xml")) {
            final CalculateService calculateService = applicationContext.getBean("calculateService", CalculateService.class);
            calculateService.add(1, 2);
        }
    }
}
