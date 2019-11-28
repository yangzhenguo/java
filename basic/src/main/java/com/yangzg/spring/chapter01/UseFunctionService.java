package com.yangzg.spring.chapter01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Created by Sam on 2019/6/18.
 */
@Service
public class UseFunctionService {
    @Autowired
    @Lazy
    private FunctionService functionService;

    public String sayHello(String world) {
        return this.functionService.sayHello(world);
    }
}
