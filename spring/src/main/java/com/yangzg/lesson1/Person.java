package com.yangzg.lesson1;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sam on 2020/3/13.
 */
@Data
@NoArgsConstructor
public class Person {
    private String name;
    private int age;
    private Car car;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
