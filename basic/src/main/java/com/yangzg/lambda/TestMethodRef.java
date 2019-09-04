package com.yangzg.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by Sam on 2019/9/4.
 */
public class TestMethodRef {
    public static void main(String[] args) {
        test5();
    }

    private static void test5() {
        Function<Integer, Employee[]> function = Employee[]::new;
        System.out.println(function.apply(10).length);
    }

    private static void test4() {
        Supplier supplier = Employee::new;
        System.out.println(supplier.get());
    }

    private static void test3() {
        Test haha = (x, y, z) -> x + y + z;
        haha = String::replace;
        System.out.println(haha.test("abc", "b", "B"));
    }

    private static void test2() {
        Employee yzg = new Employee("yzg", 12, 323);
        Consumer<Employee> consumer = Employee::printName;
        consumer.accept(yzg);
    }

    private static void test1() {
        Supplier<Double> supplier = Math::random;
        System.out.println(supplier.get());
    }

    interface Test {
        String test(String str1, String str2, String str3);
    }
}
