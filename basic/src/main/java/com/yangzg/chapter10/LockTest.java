package com.yangzg.chapter10;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Sam on 2019/7/4.
 */
public class LockTest {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test2() {
        Callable<Integer> callable = new Callable<Integer>() {
            int count = 100;
            Lock lock = new ReentrantLock();
            @Override
            public Integer call() throws Exception {
                while (true) {
                    lock.lock();
                    try {
                        if (this.count <= 0) {
                            break;
                        }
                        System.out.println(String.format("Thread: %s, count: %s", Thread.currentThread(), this.count));
                        this.count--;
                    } finally {
                        lock.unlock();
                    }
                }
                return this.count;
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Integer> future1 = executorService.submit(callable);
        Future<Integer> future2 = executorService.submit(callable);
        Future<Integer> future3 = executorService.submit(callable);
        try {
            System.out.println("" + future1.get() + future2.get() + future3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    private static void test1() {
        Callable<Integer> tickets = new Callable<Integer>() {
            private int count = 100;
            @Override
            public Integer call() throws Exception {
                while (true) {
                    if (this.consume() <= 0) {
                        break;
                    }
                }
                return this.count;
            }

            public synchronized int consume() throws InterruptedException {
                if (this.count <= 0) {
                    return this.count;
                }
                Thread.sleep(20);
                System.out.println(String.format("Thread: %s, ticket %s.", Thread.currentThread(), this.count));
                return this.count--;
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future1 = executorService.submit(tickets);
        Future<Integer> future2 = executorService.submit(tickets);
        Future<Integer> future3 = executorService.submit(tickets);
        try {
            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
            System.exit(0);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
