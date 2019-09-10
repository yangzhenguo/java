package com.yangzg.thread;

import org.junit.Test;

/**
 * Created by Sam on 2019/9/10.
 */
public class Test2 {
    @Test
    public void test1() {
        Thread other = new Thread(new Runnable1());
        other.start();

        Thread thread = new Thread(new Runnable2());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());
    }

    @Test
    public void test2() throws InterruptedException {
        Thread other = new Thread(new Runnable1());
        other.start();

        Thread thread = new Thread(() -> {
            try {
                other.join(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        System.out.println(thread.getState());
        Thread.sleep(100);
        System.out.println(thread.getState());
    }

    @Test
    public void test3() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        Thread.sleep(200);
        System.out.println(thread.getState());
    }

    class Runnable1 implements Runnable {
        @Override
        public void run() {
            synchronized (Runnable.class) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Runnable2 implements Runnable {
        @Override
        public void run() {
            synchronized (Runnable.class) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}