package com.yangzg.beans;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by Sam on 2019/11/14.
 */
@Data
public class Student implements InitializingBean {
    private String name;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("student bean have been initialized.");
    }

    public void destroy() {
        System.out.println("student bean destroyed");
    }
}
