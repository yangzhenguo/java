package com.yangzg.chapter04;

import java.util.Optional;
import java.util.Random;

/**
 * Created by Sam on 2019/6/15.
 */
public class OptionalTest {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();
    }

    private static void test5() {
        Optional.of(new Person(1)).filter(item -> item.getAge() > 0).ifPresent(System.out::println);
    }

    private static void test4() {
        Integer i = null;
        Integer integer = Optional.ofNullable(i).orElseGet(() -> new Random().nextInt());
        System.out.println(integer);
    }

    private static void test3() {
        Optional.of(new Random().nextInt(10))
                .filter(num -> num % 2 == 0)
                .ifPresent(System.out::println);
    }

    private static void test2() {
        boolean equals = Optional.ofNullable(1).equals(Optional.of(1));
        System.out.println(equals);
    }

    private static void test1() {
        Object o = Optional.empty().orElse(-1);
        System.out.println(o);
    }

    static class Person {
        private int age;

        public Person(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    '}';
        }
    }
}
