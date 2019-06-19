package com.yangzg.spring.chapter02;

import org.springframework.stereotype.Service;

/**
 * Created by Sam on 2019/6/18.
 */
@Service
public class DemoAnnotationService {
    @Action(name = "注解式拦截的add操作")
    public void add(){}
}
