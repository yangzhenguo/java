package com.yangzg.config2;

import com.yangzg.service2.CalculateService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.Locale;

/**
 * Created by Sam on 2019/10/31.
 */
public class ConfigTest {
    @Test
    public void test1() {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
//            Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
            final DataSource dataSource = applicationContext.getBean("dataSource", DataSource.class);
            System.out.println(dataSource);

            final String message = applicationContext.getMessage("message", null, "hello", Locale.CHINESE);
            System.out.println(message);
        }
    }
    @Test
    public void test2() {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
            final CalculateService calculateService = applicationContext.getBean(CalculateService.class);
            calculateService.add(1, 2);
        }
    }
}
