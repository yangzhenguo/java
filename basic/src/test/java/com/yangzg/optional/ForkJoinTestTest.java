package com.yangzg.optional;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

/**
 * Created by Sam on 2019/9/5.
 */
public class ForkJoinTestTest {
    @Test
    public void test1() {
        Instant start = Instant.now();
        long sum = LongStream.rangeClosed(1, 100_000_000_000L).parallel().reduce(0, Long::sum);
        Instant end = Instant.now();
        System.out.println(String.format("sum=%s, time=%s", sum, Duration.between(start, end).toMillis()));
    }
}