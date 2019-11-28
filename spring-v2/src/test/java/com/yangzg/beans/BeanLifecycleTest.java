package com.yangzg.beans;

import com.yangzg.beans3.BeanLifecycle;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sam on 2019/11/15.
 */
public class BeanLifecycleTest {
    @Test
    public void test1() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans/beans11.xml")) {
            context.registerShutdownHook();
            final BeanLifecycle beanLifecycle = context.getBean(BeanLifecycle.class);
            System.out.println(beanLifecycle.getApplicationContext() == context);
        }
    }
}
