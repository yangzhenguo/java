package com.yangzg.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Sam on 2019/9/12.
 */
public class SCTest1 {

    @Test
    public void test1() {
        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        System.out.println(123);
                        Thread.sleep(10);
                        System.out.println(231);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // throw new RuntimeException("haha");
                }
            });
            thread.start();

            thread.setUncaughtExceptionHandler((trd, exception) -> {
                System.out.println("捕获了异常:" + exception);
            });

            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(thread);
            System.out.println(executorService);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("捕获不了异常");
        }
    }

    @Test
    public void test2() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(123);
                    Thread.sleep(10);
                    System.out.println(231);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    @Test
    public void test3() {
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}