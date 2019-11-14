package com.yangzg.beans;

import lombok.Data;

import java.util.List;

/**
 * Created by Sam on 2019/11/14.
 */
@Data
public class Classroom {
    private Address address;
    private String name;
    private List<Student> student;
}
