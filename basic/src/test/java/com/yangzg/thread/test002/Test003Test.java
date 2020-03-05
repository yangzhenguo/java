package com.yangzg.thread.test002;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Created by Sam on 2020/3/4.
 */
public class Test003Test {
    public static final List<Employee> EMPLOYEES = ImmutableList.<Employee>builder()
            .add(new Employee())
            .add(new Employee())
            .add(new Employee())
            .add(new Employee())
            .add(new Employee())
            .build();

    @Test
    public void test01() throws Exception {
        final int sum = IntStream.rangeClosed(1, 10).reduce(0, Integer::sum);
        System.out.println(sum);
    }

    @Test
    public void test02() throws Exception {
        final Joiner joiner = Joiner.on(",").useForNull("空");

        final ArrayList<String> strings1 = Lists.newArrayList(
                "yzg",
                "sam",
                null,
                "yangzg"
        );

        System.out.println(joiner.join(strings1));

    }

    @Test
    public void test03() throws Exception {
        System.out.println(filter(EMPLOYEES, employee -> employee.getAge() > 10));

        IntStream.builder().add(1).add(2).build().peek(System.out::println).mapToObj(Double::valueOf).forEach(System.out::println);
    }

    @Test
    public void test04() throws Exception {
        Predicate<Employee> lmd1 = e -> e.getAge() > 10;
        Predicate<Employee> lmd2 = e -> e.getAge() < 50;
        filter(EMPLOYEES, lmd1.or(lmd2));

        Consumer<Integer> consumer = System.out::println;
        consumer.accept(1234);
    }

    @Test
    public void test05() throws Exception {
        IntUnaryOperator supplier = new Random()::nextInt;
        System.out.println(supplier.applyAsInt(123));

    }

    private List<Employee> filter(List<Employee> emps, Predicate<Employee> predicate) {
        final List<Employee> employees = new ArrayList<>();
        for (Employee emp :
                emps) {
            if (predicate.test(emp)) {
                employees.add(emp);
            }
        }
        return employees;
    }

    @Data
    static class Employee {
        private String name;
        private int age;
        private double salary;
    }
}