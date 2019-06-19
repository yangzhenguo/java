package com.yangzg.spring.chapter02;

import org.springframework.context.annotation.*;

import java.io.BufferedReader;
import java.io.StringReader;

/**
 * Created by Sam on 2019/6/18.
 */
@Configuration
@ComponentScan("com.yangzg.spring.chapter02")
@EnableAspectJAutoProxy
public class Config {
    @Bean
    public UseFunctionService useFunctionService(FunctionService functionService) {
        return new UseFunctionService(functionService);
    }

    @Bean
    @Scope
    public FunctionService functionService() {
        return new FunctionService();
    }

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class)) {
            UseFunctionService useFunctionService = applicationContext.getBean(UseFunctionService.class);
            new BufferedReader(new StringReader(useFunctionService.sayHello("world"))).lines().forEach(System.out::println);

            DemoAnnotationService demoAnnotationService = applicationContext.getBean(DemoAnnotationService.class);
            demoAnnotationService.add();
        }
    }
}
