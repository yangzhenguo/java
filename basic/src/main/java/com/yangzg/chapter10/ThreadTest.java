package com.yangzg.chapter10;

import java.util.Date;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Created by Sam on 2019/6/28.
 */
public class ThreadTest {
    public static void main(String[] args) {
        test5();
    }

    private static void test5() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        IntStream.range(1, 100).forEach(num -> executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + ": " + num);
        }));
    }

    private static void test4() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        try {
            System.out.println(thread.getState());
            thread.start();
            System.out.println(thread.getState());
            Thread.sleep(1000);
            System.out.println(thread.getState());
            Thread.sleep(5000);
            System.out.println(thread.getState());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void test3() {
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(2);
        ScheduledFuture<Date> schedule = pool.schedule((Callable<Date>) Date::new, 3, TimeUnit.SECONDS);
        try {
            System.out.println("ha");
            Date date = schedule.get();
            System.out.println(date);
            pool.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void test2() {
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(2);

        pool.scheduleAtFixedRate(() -> {
            System.out.println(new Date());
        }, 0, 1, TimeUnit.SECONDS);
    }

    private static void test1() {
        new Thread(() -> System.out.println(new Date())).start();
    }
}
