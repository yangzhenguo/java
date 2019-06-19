package com.yangzg.chapter07;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created by Sam on 2019/6/18.
 */
public class AppleTest {
    private List<Apple> apples = Arrays.asList(new Apple("yellow", 1), new Apple("green", 3), new Apple("blue", 2));

    @Test
    public void test1() {
        List<Apple> result = Apple.filterApples(this.apples, Apple::isGreenApple).stream().peek(apple -> {
            System.out.println(apple.toString());
        }).collect(Collectors.toList());
        assertFalse(result.isEmpty());
    }

    @Test
    public void test2() {
        assertTrue(Apple.filterApples(this.apples, Apple::isHeavyApple).size() <= 0);
    }

    @Test
    public void test3() {
        assertTrue(MathUtil.filter(this.apples, Apple::isHeavyApple).size() <= 0);
    }

    @Test
    public void test4() {
        List<Apple> collect = this.apples.stream().filter((Apple apple) -> apple.getWeight() > 150).collect(Collectors.toList());
        assertTrue(collect.isEmpty());
    }
}