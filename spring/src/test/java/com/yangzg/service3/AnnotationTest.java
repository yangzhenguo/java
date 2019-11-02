package com.yangzg.service3;

import com.yangzg.config1.ApplicationConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by Sam on 2019/10/31.
 */
public class AnnotationTest {
    @Test
    public void test1() {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
            Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
//            final CalculateService calculateService = applicationContext.getBean(CalculateService.class);
//            System.out.println(calculateService.add(1, 4));
            final Properties properties = applicationContext.getBean("properties", Properties.class);
            System.out.println(properties);

//            final String profile = applicationContext.getBean("profile", String.class);
//            System.out.println(profile);
        }
    }
}
