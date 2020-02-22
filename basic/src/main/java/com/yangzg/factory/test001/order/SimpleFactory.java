package com.yangzg.factory.test001.order;

import com.yangzg.factory.test001.model.ChessPizza;
import com.yangzg.factory.test001.model.GreekPizza;
import com.yangzg.factory.test001.model.PepperPizza;
import com.yangzg.factory.test001.model.Pizza;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Sam on 2020/2/21.
 * @author Sam
 */
public class SimpleFactory {
    private static final Map<String, Pizza> PIZZA_MAP = new ConcurrentHashMap<>();

    static {
        register(new ChessPizza(), new GreekPizza(), new PepperPizza());
    }

    public static void register(Pizza ...pizza) {
        Arrays.stream(pizza).forEach(p -> PIZZA_MAP.put(p.getName(), p));
    }

    public static Pizza create(String name) {
        return PIZZA_MAP.get(name);
    }
}
