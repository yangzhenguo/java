package com.yangzg.juc;

import org.junit.Test;

/**
 * Created by Sam on 2019/9/6.
 */
public class VolatileTest {
    @Test
    public void test1() {
        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();

        while (true) {
            if (runnable.isFlag()) {
                System.out.println(new String(new char[10]).replace("\0", "-"));
                break;
            }
        }
    }

}

class MyRunnable implements Runnable {
    private volatile boolean flag;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
            this.flag = true;
            System.out.println(this.flag);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isFlag() {
        return flag;
    }
};