package com.yangzg.beans3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sam on 2019/11/14.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends User {
    private String name;
    @Override
    public void say() {
        System.out.println("I am student");
    }
}
