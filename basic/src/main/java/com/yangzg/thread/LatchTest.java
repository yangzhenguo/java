package com.yangzg.thread;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Sam on 2019/9/14.
 */
public class LatchTest {
    public static void main(String[] args) {
        int length = 10;
        CountDownLatch latch = new CountDownLatch(length);
        List<FutureTask<Integer>> futureTasks = IntStream.rangeClosed(1, length*100).boxed().map(num -> {
            FutureTask<Integer> task = new FutureTask<>(new MyRunnable(num, num + length, latch));
            new Thread(task).start();
            return task;
        }).collect(Collectors.toList());
        try {
            boolean success = latch.await(200, TimeUnit.MILLISECONDS);
            if (success) {
                int sum = futureTasks.stream().mapToInt((FutureTask<Integer> future) -> {
                    try {
                        return future.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    return 0;
                }).sum();
                System.out.println(sum);
            } else {
                System.out.println("超时了");
                futureTasks.forEach(future -> {
                    if (!future.isDone()) {
                        future.cancel(true);
                    }
                });
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyRunnable implements Callable<Integer> {
    int start;
    int end;
    CountDownLatch latch;

    public MyRunnable(int start, int end, CountDownLatch latch) {
        this.start = start;
        this.end = end;
        this.latch = latch;
    }

    @Override
    public Integer call() throws Exception {
        try {
            Thread.sleep(10000);
            return IntStream.rangeClosed(start, end).sum();
        } finally {
            this.latch.countDown();
        }
    }
}