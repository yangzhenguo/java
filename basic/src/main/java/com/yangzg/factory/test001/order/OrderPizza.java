package com.yangzg.factory.test001.order;

import com.yangzg.factory.test001.model.Pizza;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Sam on 2020/2/21.
 * @author Sam
 */
public class OrderPizza {
    public Pizza order(final String name) {
        return SimpleFactory.create(name);
    }

    public static void main(String[] args) {
        System.out.println(SimpleFactory.create("pepper"));

        final ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>(new HashMap<>(1 >> 4));
        System.out.println(1 >> 4);
    }
}
