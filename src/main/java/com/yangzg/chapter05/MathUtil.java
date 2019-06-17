package com.yangzg.chapter05;

import java.util.Random;

/**
 * Created by Sam on 2019/6/17.
 */
public interface MathUtil {
    Random RANDOM = new Random();

    static int[] generateRandomNums(final int length) {
        return RANDOM.ints(length, 0, Integer.MAX_VALUE).toArray();
    }
}
