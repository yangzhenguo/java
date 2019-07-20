package com.hiyzg.principle.sg;

/**
 * Created by Sam on 2019/7/20.
 */
public class B implements Interface1, Interface2 {
    @Override
    public void operation1() {
        System.out.println("B implements operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B implements operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B implements operation3");
    }
}
