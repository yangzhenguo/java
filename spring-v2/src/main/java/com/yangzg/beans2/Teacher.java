package com.yangzg.beans2;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by Sam on 2019/11/14.
 */
@Data
public class Teacher {
    private String name;
    private Student student;
    private List<Student> students;
    private Map<String, Object> objects;
}
