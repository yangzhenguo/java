package com.yangzg.optional;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Sam on 2019/9/5.
 */
public class OptionalTestTest {
    @Test
    public void test1() {
        String dir = String.valueOf(Optional.empty().orElseGet(() -> System.getProperty("user.dir")));
        System.out.println(dir);
    }

    @Test
    public void test2() {
        Optional.of("hello world").map(String::toUpperCase).ifPresent(System.out::println);
    }

    @Test
    public void test3() {
        Optional.of("hello world").flatMap(str -> {
            return Optional.of(str);
        }).ifPresent(System.out::println);
    }

    @Test
    public void test4() {
        Stream.generate(HashMap<String, Double>::new)
                .limit(10)
                .peek(m -> m.put("count", Math.random()))
                .sorted(Comparator.comparingDouble((HashMap<String, Double> m) -> m.get("count")).reversed())
                .collect(Collectors.partitioningBy(m -> m.get("count") > .5))
                .forEach((k, v) -> System.out.println(String.format("key=%s, value=%s", k, v)));
    }
}