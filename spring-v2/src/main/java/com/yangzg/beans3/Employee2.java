package com.yangzg.beans3;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Sam on 2019/11/15.
 */
@Data
@Component("employee")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Employee2 {
    @Value("#{T(java.lang.Math).random()}")
    double no;

    @PostConstruct
    public void init() {
        System.out.println(String.format("%s employee init", this.no));
    }

    @PreDestroy
    public void destroy() {
        System.out.println("%s bean destroyed");
    }
}
