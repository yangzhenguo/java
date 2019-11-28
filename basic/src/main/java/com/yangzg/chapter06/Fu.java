package com.yangzg.chapter06;

import java.awt.*;
import java.util.function.BinaryOperator;

/**
 * Created by Sam on 2019/6/17.
 */
public class Fu {
    int a = 1;

    public Fu(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Button button = new Button();
        button.addActionListener(e -> System.out.println(e.getActionCommand()));

        Runnable run = System.out::println;

        BinaryOperator<Long> bo = (Long x, Long y) -> x + y;
    }
}
