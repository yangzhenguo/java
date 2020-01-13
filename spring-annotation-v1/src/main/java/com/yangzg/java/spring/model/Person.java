package com.yangzg.java.spring.model;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.Lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Sam on 2020/1/11.
 * @author Sam
 */
@Data
public class Person implements Lifecycle, InitializingBean, DisposableBean {
    public Person() {
        System.out.println("constructor");
    }

    public void init() {
        System.out.println("init");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy");
    }

    @Override
    public void start() {
        System.out.println("start");
    }

    @Override
    public void stop() {
        System.out.println("stop");
    }

    @Override
    public boolean isRunning() {
        return true;
    }
}
