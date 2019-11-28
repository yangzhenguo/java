package com.hiyzg.principle.sg;

/**
 * Created by Sam on 2019/7/20.
 */
public class C {
    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend3(Interface3 i) {
        i.operation4();
    }

    public void depend4(Interface3 i) {
        i.operation5();
    }
}
