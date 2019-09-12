package com.yangzg.thread;

/**
 * Created by Sam on 2019/9/12.
 */
public class Test2 {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(123);
                    Thread.sleep(1000);
                    System.out.println(231);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
