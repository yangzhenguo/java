package com.yangzg.thread;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Sam on 2020/2/19.
 */
public class FirstThreadTest {
    @Test
    public void test1() throws Exception {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}