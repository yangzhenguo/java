package com.yangzg.lambda;

import com.yangzg.lambda.strategy.BySalaryFilterStrategy;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Sam on 2019/9/2.
 */
public class TestLambda {
    private static final List<Employee> employees = Arrays.asList(
            new Employee("zhang san", 18, 9_999.99),
            new Employee("li si", 38, 5_555.55),
            new Employee("wang wu", 50, 6_666.66),
            new Employee("zhao liu", 16, 3_333.33),
            new Employee("tian qi", 8, 7_777.77)
    );

    public static void main(String[] args) {
        test11();
    }

    private static void test11() {
        Collections.nCopies(10, 0).stream().map(n -> n).forEach(System.out::println);
    }

    private static void test10() {
        System.out.println(transStr("ff", String::toUpperCase));
    }

    private static String transStr(String string, Function<String, String> transfer) {
        return transfer.apply(string);
    }

    private static void test9() {
        employees.sort(Comparator.comparingDouble(Employee::getSalary));
        employees.forEach(System.out::println);
    }

    private static void test8() {
        Consumer<Integer> consumer = System.out::println;
        consumer.accept(123);
    }

    private static void test7() {
        int num = 0;

        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Lambda");
            }
        };

        run.run();

        System.out.println(new String(new char[30]).replace("\0", "-"));

        Runnable runnable = () -> {
            System.out.println("Hello Lambda");
        };
        runnable.run();
    }

    private static void test6() {
        employees.stream()
                .filter(e -> e.getSalary() >= 5_000)
                .limit(2)
                .forEach(System.out::println);
        System.out.println(new String(new char[30]).replace("\0", "*"));

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    private static void test5() {
        List<Employee> list = filter(employees, emp -> emp.getSalary() >= 5_000);
        list.forEach(System.out::println);
    }

    private static void test4() {
        System.out.println(filter(employees, new BySalaryFilterStrategy(5_000)));
    }

    private static void test3() {
        System.out.println(filterEmployees(employees));
    }

    public static List<Employee> filterEmployees(List<Employee> list) {
        return list.stream().filter(emp -> emp.getAge() >= 35).collect(Collectors.toList());
    }

    private static void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> set = new TreeSet<>(com);
        set.add(3);
        set.add(1);
        set.add(2);
        System.out.println(set);
    }

    private static void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(com);
    }

    private static List<Employee> filter(List<Employee> employees, MyPredicate<Employee> predicate) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : employees) {
            if (predicate.test(employee)) {
                emps.add(employee);
            }
        }
        return emps;
//        return employees.stream().filter(employee -> predicate.test(employee)).collect(Collectors.toList());
    }
}
