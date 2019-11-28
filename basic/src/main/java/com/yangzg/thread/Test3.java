package com.yangzg.thread;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Sam on 2019/9/12.
 */
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();
        while (true) {
            if (runnable.isFlag()) {
                System.out.println("-------");
                break;
            }
        }
    }

    static class MyRunnable implements Runnable {
        private AtomicBoolean flag = new AtomicBoolean(false);

        public boolean isFlag() {
            return flag.get();
        }

        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.flag.set(true);
            System.out.println("trued....");
        }
    }
}
