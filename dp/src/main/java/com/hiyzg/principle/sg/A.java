package com.hiyzg.principle.sg;

/**
 * Created by Sam on 2019/7/20.
 */
public class A {
    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend2(Interface2 i) {
        i.operation2();
    }

    public void depend3(Interface2 i) {
        i.operation3();
    }
}
