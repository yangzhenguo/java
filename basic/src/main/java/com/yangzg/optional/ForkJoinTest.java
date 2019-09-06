package com.yangzg.optional;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Sam on 2019/9/5.
 */
public class ForkJoinTest {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        Long sum = pool.invoke(new MyTask(0, 100_000_000L));
        System.out.println(sum);
    }
}

class MyTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 10000;
    private long start;
    private long end;

    public MyTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (this.end - this.start <= THRESHOLD) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (end + start) / 2;
            MyTask left = new MyTask(start, middle);
            left.fork();
            MyTask right = new MyTask(middle + 1, end);
            right.fork();
            return left.join() + right.join();
        }
    }
}