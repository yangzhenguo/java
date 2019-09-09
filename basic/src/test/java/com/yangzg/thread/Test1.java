package com.yangzg.thread;

import org.junit.Test;

/**
 * Created by Sam on 2019/9/9.
 */
public class Test1 {
    @Test
    public void test1() {
        Runnable runnable = new Runnable() {
            private int ticket = 100;

            @Override
            public void run() {
                this.sell();
            }

            public synchronized void sell() {
                while (ticket >= 0) {
                    System.out.println(String.format("%s 卖出了第%d张票", Thread.currentThread().getName(), ticket--));
                }
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

}