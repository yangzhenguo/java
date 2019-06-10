package com.yangzg.chapter03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Created by Sam on 2019/6/10.
 */
public class Array {
    public static void main(String[] args) {
        test1();

        test2();

        Integer integer = null;
        System.out.println(integer);
    }

    private static void test1() {
        int[] arr = new int[]{1, 3, 5};
        System.out.println(Arrays.toString(arr));
    }

    private static void test2() {
        Random random = new Random();
        int[] arr = new int[5];
        Stream<Integer> limit = Stream.generate(() -> random.nextInt(100)).limit(10);
//        limit.forEach(System.out::println);
        Integer integer = limit.max(Comparator.comparingInt(i -> i)).orElse(0);
        System.out.println(integer);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
