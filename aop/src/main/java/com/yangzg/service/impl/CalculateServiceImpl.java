package com.yangzg.service.impl;

import com.yangzg.service.CalculateService;
import org.springframework.stereotype.Service;

/**
 * Created by Sam on 2019/11/19.
 */
@Service
public class CalculateServiceImpl implements CalculateService {
    @Override
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int multi(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public void divide(int num1, int num2) {
        int rtn = num1 / num2;
    }
}
