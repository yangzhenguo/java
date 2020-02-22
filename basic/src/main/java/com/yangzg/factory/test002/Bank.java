package com.yangzg.factory.test002;

/**
 * Created by Sam on 2020/2/22.
 */
public class Bank {
    private static Bank instance = null;

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
}
