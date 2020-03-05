package com.yangzg.factory.test002;

import java.util.Random;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by Sam on 2020/2/22.
 */
public class Bank {
    private static Bank instance = null;

    private int amount;

    private Random random = new Random();

    public synchronized void plus() {
        if (this.amount >= 2000) {
            notifyAll();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.amount += 100;
        System.out.println(String.format("[%s]充值%s", Thread.currentThread().getName(), 100));
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(100) + 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void minus() {
        if (this.amount <= 500) {
            notifyAll();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.amount -= 100;
        System.out.println(String.format("[%s]消费%s", Thread.currentThread().getName(),100));
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(100) + 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Bank() {}

    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        final Bank bank = Bank.getInstance();
        IntStream.rangeClosed(1, 10).forEach(num -> new Thread(new FutureTask(() -> {
            while (true) {
                bank.plus();
            }
        }), String.format("Producer-%s", num)).start());

        IntStream.rangeClosed(1, 10).forEach(num -> new Thread(new FutureTask(() -> {
            while (true) {
                bank.minus();
            }
        }), String.format("Consumer-%s", num)).start());
    }
}
