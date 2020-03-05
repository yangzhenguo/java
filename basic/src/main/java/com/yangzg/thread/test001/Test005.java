package com.yangzg.thread.test001;

import java.util.concurrent.TimeUnit;

/**
 * Created by Sam on 2020/2/24.
 */
public class Test005 {
    private static Boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            while (flag) {
                synchronized (flag) {
                    if (!flag) {
                        System.out.println(flag);
                        break;
                    }
                }
            }
        };

        new Thread(runnable).start();

        TimeUnit.MILLISECONDS.sleep(10);
        setFlag(false);
    }

    public static void setFlag(boolean flag) {
        Test005.flag = flag;
    }
}

