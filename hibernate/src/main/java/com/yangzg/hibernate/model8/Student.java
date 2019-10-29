package com.yangzg.hibernate.model8;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Set;

/**
 * Created by Sam on 2019/10/29.
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {
    private Integer id;
    @NonNull
    private String name;
    private Set<Teacher> teachers;

    public Student(String name, Set<Teacher> teachers) {
        this.name = name;
        this.teachers = teachers;
    }
}
