package com.yangzg.chapter06;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Sam on 2019/6/17.
 */
public class PersonTest {
    @Test
    public void test1() {
        Person sam = new Person("sam", 21);
        System.out.println(sam);

        int a[] = {3,2,6,1};
        Arrays.sort(a);
        System.out.println(Arrays.binarySearch(a, 4));

        List<Person> personList = new ArrayList<>();
        gg(personList);
    }

    public <T extends Comparable<? super T>> T gg(List<T> list) {
        return list.get(0);
    }
}