package com.hiyzg.principle.sg;

/**
 * Created by Sam on 2019/7/20.
 */
public class Main {
    public static void main(String[] args) {
        new A().depend1(new B());
        new A().depend2(new B());
        new A().depend3(new B());

        new C().depend1(new D());
        new C().depend3(new D());
        new C().depend4(new D());
    }
}
