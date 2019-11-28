package com.yangzg.model1;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Sam on 2019/10/30.
 */
@Data
@AllArgsConstructor
public class Person {
    private String name;
    private int age;
    private Car car;
}
