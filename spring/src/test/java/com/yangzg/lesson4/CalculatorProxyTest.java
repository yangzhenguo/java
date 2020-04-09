package com.yangzg.lesson4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.UrlResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by Sam on 2020/3/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/lesson4/applicationContext.xml"})
public class CalculatorProxyTest {
    @Autowired
    @Lazy
    private ApplicationContext applicationContext;

    @Autowired
    @Lazy
    private com.yangzg.lesson5.Calculator calculator;

    @Autowired
    @Lazy
    private com.yangzg.lesson5.Calculator calculator7;

    @Value("#{systemProperties['user.timezone']}")
    private String timezone;

    @Autowired
    @Lazy
    private Map<String, Object> map;

//    @Value("file:///Users/Sam/Downloads/ol.html")
    @Value("http://www.baidu.com")
    private UrlResource resource;

    @Test
    public void getInstance() throws Exception {
        final Calculator calculator = CalculatorProxy.getInstance(new MyCalculator());
        System.out.println(calculator.getClass());
        System.out.println(calculator.sum(12, 32));
    }

    @Test
    public void test1() throws Exception {
        this.calculator.plus(1, 2);
        System.out.println(this.calculator.getClass());
    }

    @Test
    public void test2() throws Exception {
        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/lesson4/applicationContext.xml");
        System.out.println(applicationContext.containsBean("calculator5"));

        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("-----");
        Arrays.stream(applicationContext.getAliases("calculator")).forEach(System.out::println);
    }

    @Test
    public void test3() throws Exception {
//        final Calendar calendar = this.applicationContext.getBean(Calendar.class);
        this.map.forEach((k, v) -> System.out.println(String.format("%s\t%s", k, v)));
        try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.resource.getInputStream()))) {
            bufferedReader.lines().forEach(System.out::println);
            System.out.println(this.resource.isOpen());
            System.out.println(this.resource.exists());
        }

        System.out.println(this.applicationContext.getResource("com/yangzg/dao4/BookDao.class").getClass());

        System.out.println(this.applicationContext.getResource("classpath:com/yangzg/dao4/BookDao.class").getClass());

        System.out.println(this.calculator7.getAbc());
    }
}