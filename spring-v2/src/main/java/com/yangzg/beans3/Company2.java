package com.yangzg.beans3;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Sam on 2019/11/15.
 */
@Component("company")
public abstract class Company2 {
    @Lookup
    public abstract Employee2 getEmployee();

    @PostConstruct
    public void init() {
        System.out.println("company init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("company destroyed");
    }
}
