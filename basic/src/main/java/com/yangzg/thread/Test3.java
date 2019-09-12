package com.yangzg.thread;

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
        private boolean flag = false;

        public boolean isFlag() {
            return flag;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.flag = true;
            System.out.println("trued....");
        }
    }
}
