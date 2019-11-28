package com.hiyzg.shop.util;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sam on 2019/10/17.
 */
public class ThreadLocalTest {
    public class MyTask implements Runnable {
        private String name;

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                this.name = Thread.currentThread().getName();
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(String.format("%s: %s", Thread.currentThread().getName(), this.name));
            }
        }
    }

    public class MyTask2 implements Runnable {
        private ThreadLocal<String> name = new ThreadLocal<>();

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                this.name.set(Thread.currentThread().getName());
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(String.format("%s: %s", Thread.currentThread().getName(), this.name.get()));
            }
        }
    }

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        final MyTask task = new MyTask();
        new Thread(task, "AAA").start();
        new Thread(task, "BBB").start();
        TimeUnit.SECONDS.sleep(3);
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        final MyTask2 task = new MyTask2();
        new Thread(task, "AAA").start();
        new Thread(task, "BBB").start();
        TimeUnit.SECONDS.sleep(3);
    }
}
