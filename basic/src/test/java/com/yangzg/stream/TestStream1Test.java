package com.yangzg.stream;

import com.yangzg.lambda.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Sam on 2019/9/4.
 */
public class TestStream1Test {
    private static final List<Employee> employees = Arrays.asList(
            new Employee("zhang san", 18, 9_999.99),
            new Employee("li si", 38, 5_555.55),
            new Employee("wang wu", 50, 6_666.66),
            new Employee("zhao liu", 16, 3_333.33),
            new Employee("tian qi", 8, 7_777.77)
    );

    @Test
    public void test1() throws Exception {
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        Employee[] employees = new Employee[10];
        Stream<Employee> employeeStream = Arrays.stream(employees);

        Stream<String> stringStream = Stream.of("a", "b", "c");

        Stream<Double> limit = Stream.generate(Math::random).limit(100);
        limit.forEach(System.out::println);
    }

    @Test
    public void test2() {
        employees.stream().filter(employee -> employee.getSalary() > 5_000).forEach(System.out::println);
    }

    @Test
    public void test3() {
        Stream<Employee> stream = employees.stream().filter(employee -> {
            System.out.println("hah");
            return true;
        });
        System.out.println(new String(new char[10]).replace("\0", "-"));
        stream.forEach(System.out::println);
    }

    @Test
    public void test4() {
        List<String> strings = Arrays.asList("aaa", "bbb", "ccc");
        strings.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @Test
    public void test6() {
        Double collect = employees.stream().collect(Collectors.averagingInt(Employee::getAge));
        System.out.println(collect);
    }

    @Test
    public void test7() {
        Long count = employees.stream().collect(Collectors.counting());
        System.out.println(count);
    }

    @Test
    public void test8() {
        Double sum = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);
    }

    @Test
    public void test9() {
        employees.stream().max(Comparator.comparingInt(Employee::getAge)).ifPresent(System.out::println);
    }

    @Test
    public void test10() {
        Map<String, Double> map = employees.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary));
        System.out.println(map);
    }
}