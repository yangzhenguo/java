package com.yangzg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sam on 2019/9/18.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int age;
    private String username;

    public String toJSONString() {
        return String.format("{\"age\":%d,username:\"%s\"}", age, username);
    }
}
