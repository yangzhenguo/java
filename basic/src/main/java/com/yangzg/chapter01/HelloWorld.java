package com.yangzg.chapter01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Created by Sam on 2019/6/8.
 */
public class HelloWorld {
    public static void main(String[] args) {
        int i = 10;
        int j = 0b101010;
        int k = 99_99_67;
        System.out.println(k);
        System.out.println('\u1234');

        System.out.println(randomNums(300, 100));
        Stream.iterate(65, item -> item + 1).limit(1000).forEach(item -> System.out.print((char)item.shortValue()));
    }

    public static List<Integer> randomNums(int num, int count) {
        Random random = new Random();
        List<Integer> nums = new ArrayList<>();
        while (count > 1) {
            int sup = num - count--;
            int value = sup <= 1 ? 1 : (random.nextInt(sup - 1) + 1);
            nums.add(value);
            num -= value;
        }
        nums.add(num);
        return nums;
    }
}
