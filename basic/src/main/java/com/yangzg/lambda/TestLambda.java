package com.yangzg.lambda;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by Sam on 2019/9/2.
 */
public class TestLambda {
    public static void main(String[] args) {
        test2();
    }

    private static void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> set = new TreeSet<>(com);
        set.add(3);
        set.add(1);
        set.add(2);
        System.out.println(set);
    }

    private static void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(com);
    }
}
