package com.yangzg.service2;

import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Sam on 2019/11/1.
 */
@Component
public class LifeCycleService {
    public LifeCycleService() {
        System.out.println("constructor");
    }

    @PostConstruct
    public Object postProcessBeforeInitialization() throws BeansException {
        System.out.println("before init");
        return null;
    }

    @PreDestroy
    public void postProcessAfterInitialization() throws BeansException {
        System.out.println("after init");
    }
}
