package com.yangzg.lesson5;

import com.yangzg.lesson5.annotation.Min;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

/**
 * Created by Sam on 2020/3/22.
 */
@Service
public class CalculatorImpl implements Calculator {
    @Override
    public int plus(int a, int b) {
        return Integer.sum(a, b);
    }

    @Override
    public int minus(int a, int b) {
        return Integer.sum(a, -b);
    }

    @Override
    public int div(int a, @Min int b) {
        return a / b;
    }

    public static class ABC {
    }

    private Resource abc;

    @Override
    public Resource getAbc() {
        return abc;
    }

    public void setAbc(Resource abc) {
        this.abc = abc;
    }
}
