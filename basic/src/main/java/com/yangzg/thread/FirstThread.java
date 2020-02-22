package com.yangzg.thread;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by Sam on 2020/2/19.
 * @author Sam
 */
public class FirstThread {
    public static void main(String[] args) throws InterruptedException {
        final Thread thread1 = new Thread(() -> IntStream.rangeClosed(1, 10).forEach(num -> {
            try {
                System.out.println(String.format("%s: %d", Thread.currentThread().getName(), num));
                TimeUnit.SECONDS.sleep(1);
                if (num == 2) {
                    throw new RuntimeException("abc");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }), "thread1");
        final Thread thread2 = new Thread(() -> IntStream.rangeClosed(1, 10).forEach(num -> {
            try {
                System.out.println(String.format("%s: %d", Thread.currentThread().getName(), num));
                TimeUnit.SECONDS.sleep(1);
                if (num == 3) {
                    thread1.join(3000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }), "thread2");

        thread1.start();
        thread2.start();
        thread1.setUncaughtExceptionHandler((t, e) -> {
            System.out.println(t);
            System.out.println(e);
        });
    }
}
