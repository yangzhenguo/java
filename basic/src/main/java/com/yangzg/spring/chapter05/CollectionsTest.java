package com.yangzg.spring.chapter05;

import com.yangzg.chapter06.Person;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sam on 2019/6/26.
 */
public class CollectionsTest {
    public static void main(String[] args) {
        test4();
    }

    private static void test4() {
    }

    private static void test3() {
        Map<Person, Person> personPersonMap = Collections.singletonMap(new Person("sam", 32), new Person("ff", 23));
        personPersonMap.put(new Person("fjj", 52), new Person("gl", 21));
        System.out.println(personPersonMap);
    }

    private static void test2() {
        List<Person> personList = Collections.singletonList(new Person("sam", 23));
        personList.add(new Person("sam", 23));
        System.out.println(personList);
    }

    private static void test1() {
        Set<Person> sam = Collections.singleton(new Person("sam", 23));
        System.out.println(sam);
        sam.add(new Person("sam", 23));
        System.out.println(sam);
    }
}
