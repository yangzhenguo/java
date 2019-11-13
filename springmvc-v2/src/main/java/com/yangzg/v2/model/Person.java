package com.yangzg.v2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sam on 2019/11/8.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Long id;
    private String name;
    private int age;
}
