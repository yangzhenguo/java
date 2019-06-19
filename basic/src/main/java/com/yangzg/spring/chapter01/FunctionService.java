package com.yangzg.spring.chapter01;

import org.springframework.stereotype.Service;

/**
 * Created by Sam on 2019/6/18.
 */
@Service
public class FunctionService {
    public String sayHello(String world) {
        return "Hello " + world + " !";
    }
}
