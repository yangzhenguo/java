package com.yangzg.service2;

import org.springframework.stereotype.Service;

/**
 * Created by Sam on 2019/10/31.
 */
@Service
public class CalculateService {
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public void init() {
        System.out.println("init");
    }

    public void destroy() {
        System.out.println("destroy");
    }
}
