package com.yangzg.lesson6.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sam on 2020/3/24.
 */
@Data
@NoArgsConstructor
public class Person {
    private int id;
    private String name;

    public Person(String name) {
        this.name = name;
    }
}
