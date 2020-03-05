package com.yangzg.thread.test002;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by Sam on 2020/2/24.
 */
public class Test001 {
    private static final Map<TYPE, Function<String, String>> MAPPING = new HashMap<TYPE, Function<String, String>>() {
        private static final long serialVersionUID = 626735412868229517L;

        {
            put(TYPE.ONE, param -> param);
            put(TYPE.TWO, param -> param);
            put(TYPE.THREE, param -> param);
        }
    };

    enum TYPE {
        /**
         * ONE
         */
        ONE,

        /**
         * TWO
         */
        TWO,

        /**
         * THREE
         */
        THREE,
    }

    public static void main(String[] args) {
        System.out.println(MAPPING.get(TYPE.ONE).apply("abc"));
    }
}
