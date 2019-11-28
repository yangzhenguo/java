package com.yangzg.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Sam on 2019/9/14.
 */
public class Test4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> integerFutureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 123;
            }
        });
        new Thread(integerFutureTask).start();
        System.out.println(integerFutureTask.get());
    }
}
