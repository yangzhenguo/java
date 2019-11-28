package com.hiyzg.shop.util;

import java.sql.Connection;

/**
 * Created by Sam on 2019/10/17.
 */
public class ConnectionContext {
    private static volatile ThreadLocal<Connection> INSTANCE = null;

    private ConnectionContext() {}

    public static ThreadLocal<Connection> getInstance() {
        if (INSTANCE == null) {
            synchronized (ConnectionContext.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ThreadLocal<>();
                }
            }
        }
        return INSTANCE;
    }
}
