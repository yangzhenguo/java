package com.hiyzg.principle.sg;

/**
 * Created by Sam on 2019/7/20.
 */
public class D implements Interface1, Interface3 {
    @Override
    public void operation1() {
        System.out.println("D implements operation1");
    }

    @Override
    public void operation4() {
        System.out.println("D implements operation4");
    }

    @Override
    public void operation5() {
        System.out.println("D implements operation5");
    }
}
