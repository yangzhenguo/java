package com.yangzg.thread;

import java.util.Random;

/**
 * Created by Sam on 2019/9/12.
 */
public class SCTest {
    static Random random = new Random();

    private static class Goods {
        private int goods;

        public int getGoods() {
            return goods;
        }

        public void setGoods(int goods) {
            this.goods = goods;
        }

        public synchronized int increase() {
            try {
                if (this.getGoods() >= 50) {
                    System.out.println(String.format("物品过多，%s正在等待，通知消费者消费", Thread.currentThread().getName()));
                    notify();
                    wait();
                } else {
                    ++this.goods;
                    System.out.println(String.format("%s正在生产，生产后剩余%d", Thread.currentThread().getName(), goods));
                    Thread.sleep(random.nextInt(70));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return goods;
        }

        public synchronized int decrease() {
            try {
                if (this.goods <= 5) {
                    System.out.println(String.format("物品过少，%s正在等待，通知生产者者生产", Thread.currentThread().getName()));
                    notify();
                    wait();
                } else {
                    --this.goods;
                    System.out.println(String.format("%s正在消费，消费后剩余%d", Thread.currentThread().getName(), goods));
                    Thread.sleep(random.nextInt(100));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return goods;
        }
    }

    static class SupplierRunnable implements Runnable {
        private Goods goods;

        public SupplierRunnable(Goods goods) {
            this.goods = goods;
        }

        @Override
        public void run() {
            while (true) {
                this.goods.increase();
            }
        }
    }

    static class ConsumerRunnable implements Runnable {
        private Goods goods;

        public ConsumerRunnable(Goods goods) {
            this.goods = goods;
        }

        @Override
        public void run() {
            while (true) {
                this.goods.decrease();
            }
        }
    }

    public static void main(String[] args) {
        Goods goods = new Goods();
        ConsumerRunnable consumerRunnable = new ConsumerRunnable(goods);
        SupplierRunnable supplierRunnable = new SupplierRunnable(goods);

        new Thread(supplierRunnable, "厂家").start();
        new Thread(consumerRunnable, "顾客甲").start();
        new Thread(consumerRunnable, "顾客乙").start();
    }
}
