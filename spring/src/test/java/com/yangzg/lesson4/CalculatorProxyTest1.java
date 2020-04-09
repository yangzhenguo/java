package com.yangzg.lesson4;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Created by Sam on 2020/3/21.
 */
public class CalculatorProxyTest1 {
    @Test
    public void test1() throws Exception {
        final GenericApplicationContext context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("/lesson4/applicationContext.xml");
        context.refresh();
        System.out.println(context);

        final com.yangzg.lesson5.Calculator calculator = context.getBean("calculator", com.yangzg.lesson5.Calculator.class);
        System.out.println(calculator.minus(1, 2));
    }
}