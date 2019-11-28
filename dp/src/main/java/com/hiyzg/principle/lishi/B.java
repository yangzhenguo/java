package com.hiyzg.principle.lishi;

/**
 * Created by Sam on 2019/8/8.
 */
public class B extends A {
    @Override
    public int func1(int num1, int num2) {
        return num1 + num2;
    }

    public int func2(int a, int b) {
        return func1(a, b) + 8;
    }
}
