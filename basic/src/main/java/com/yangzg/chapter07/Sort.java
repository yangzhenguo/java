package com.yangzg.chapter07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Sam on 2019/6/18.
 */
public class Sort {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        List<Apple> apples = Arrays.asList(new Apple("blue", 2), new Apple("blue", 1), new Apple("blue", 3));
        apples.sort(Comparator.comparing(Apple::getWeight));
        apples.forEach(System.out::println);
    }
}
