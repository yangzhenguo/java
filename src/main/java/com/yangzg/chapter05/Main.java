package com.yangzg.chapter05;

import java.util.Arrays;

/**
 * Created by Sam on 2019/6/17.
 */
public class Main {
    public static void main(String[] args) {
        int[] ints = MathUtil.generateRandomNums(10);
        Arrays.stream(ints).peek(num -> System.out.println(num + ", ")).forEach(System.out::println);
    }
}
