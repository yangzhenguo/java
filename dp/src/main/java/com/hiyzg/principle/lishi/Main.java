package com.hiyzg.principle.lishi;

/**
 * Created by Sam on 2019/8/8.
 */
public class Main {
    public static void main(String[] args) {
        A a = new A();

        System.out.println(String.format("11 - 3 = %d", a.func1(11, 3)));
        System.out.println(String.format("1 - 8 = %d", a.func1(1, 8)));

        System.out.println("----------");

        B b = new B();
        System.out.println(String.format("11 - 3 = %d", b.func1(11, 3)));
        System.out.println(String.format("1 - 8 = %d", b.func1(1, 8)));
        System.out.println(String.format("11 + 3 + 8 = %d", b.func2(11, 3)));
    }
}
