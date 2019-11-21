package com.yangzg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sam on 2019/11/21.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String username;
    private String password;
    private String email;
    private int age;
    private Address address;
}
