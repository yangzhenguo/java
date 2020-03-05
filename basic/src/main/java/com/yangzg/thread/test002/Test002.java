package com.yangzg.thread.test002;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * Created by Sam on 2020/2/24.
 */
public class Test002 {
    private static final Map<TAX_TYPE, Function<Double, Double>> TAX_CALCULATOR = new HashMap<TAX_TYPE, Function<Double, Double>>() {
        private static final long serialVersionUID = -7256828030459003576L;
        {
            put(TAX_TYPE.LESS_EQUAL_2000, income -> 0D);
            put(TAX_TYPE.GREATER_2000_AND_LESS_EQUAL_2700, income -> 0.14 * (income - 2200));
            put(TAX_TYPE.GREATER_2700_AND_LESS_EQUAL_3200, income -> 70 + 0.15 * (income - 2700));
            put(TAX_TYPE.GREATER_3200_AND_LESS_EQUAL_3700, income -> 145 + 0.16 * (income - 3200));
            put(TAX_TYPE.GREATER_3700, income -> 53090 + 0.7 * (income - 102200));
        }
    };

    enum TAX_TYPE {
        /**
         * income <= 2000
         */
        LESS_EQUAL_2000,

        /**
         * 2000 < income <= 2700
         */
        GREATER_2000_AND_LESS_EQUAL_2700,

        /**
         * 2700 < income <= 3200
         */
        GREATER_2700_AND_LESS_EQUAL_3200,

        /**
         * 3200 < income <= 3700
         */
        GREATER_3200_AND_LESS_EQUAL_3700,

        /**
         * income > 3700
         */
        GREATER_3700
    }

    public static void main(String[] args) {
        System.out.println(TAX_CALCULATOR.get(TAX_TYPE.LESS_EQUAL_2000).apply(1000D));

        Integer vvv = Optional.<String>ofNullable("123").map(x -> {
            System.out.println(x);
            return Integer.valueOf(x);
        }).orElse(100);
        System.out.println(vvv); //100

        System.out.println(Optional.ofNullable("a").map(x -> Math.max(Integer.valueOf(x.toString()), 0)).orElse(0));
    }
}
