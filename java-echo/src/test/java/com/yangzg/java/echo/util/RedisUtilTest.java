package com.yangzg.java.echo.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by Sam on 2020/1/7.
 */
public class RedisUtilTest {
    @Test
    public void test1() throws Exception {
        final Integer[] strings = Stream.of(1, 2, 3, 4).toArray(Integer[]::new);
        System.out.println(Arrays.toString(strings));
    }
}