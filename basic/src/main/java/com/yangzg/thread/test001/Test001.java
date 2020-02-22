package com.yangzg.thread.test001;

/**
 * Created by Sam on 2020/2/22.
 * @author Sam
 */
public class Test001 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            private Integer count = 100;

            @Override
            public void run() {
                while (true) {
//                    this.decrease();
                    synchronized (this) {
                        if (count > 0) {
                            System.out.println(String.format("%s - count: %s", Thread.currentThread().getName(), count--));
                        } else {
                            break;
                        }
                    }
                }
            }

            synchronized void decrease() {
                if (count > 0) {
                    System.out.println(String.format("%s - count: %s", Thread.currentThread().getName(), count--));
                }
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
