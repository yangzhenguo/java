package com.yangzg.spring.chapter02;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Sam on 2019/6/18.
 */
@Data
@AllArgsConstructor
public class UseFunctionService {
    private FunctionService functionService;

    public String sayHello(String world) {
        return this.functionService.sayHello(world);
    }
}
