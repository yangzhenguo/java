package com.yangzg.thread.test001;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by Sam on 2020/2/23.
 */
public class Test002 {
    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println(executorService.getClass());
        final ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(() -> {
            IntStream.rangeClosed(1, 10).forEach(num -> {
                System.out.println(num);
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
        System.out.println(service);
        service.shutdown();

        ThreadLocalRandom.current();
    }
}
