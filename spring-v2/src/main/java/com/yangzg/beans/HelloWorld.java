package com.yangzg.beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Sam on 2019/11/13.
 */
@Data
@NoArgsConstructor
public class HelloWorld implements InitializingBean, ResourceLoaderAware, ApplicationContextAware, BeanNameAware {
    private ResourceLoader resourceLoader;
    private String name;

    private int age;

    private double salary;

    public HelloWorld(String name) {
        this.name = name;
    }

    public HelloWorld(int age) {
        this.age = age;
    }

    public HelloWorld(double salary) {
        this.salary = salary;
    }

    public void init() {
        System.out.println("init");
    }

    public String hello() {
        return String.format("Hello, %s", this.name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext");
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("setBeanName");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("setResourceLoader");
        this.resourceLoader = resourceLoader;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.resourceLoader.getResource("beans.xml").getInputStream()))) {
            bufferedReader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
