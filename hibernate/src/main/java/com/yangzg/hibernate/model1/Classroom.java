package com.yangzg.hibernate.model1;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Set;

/**
 * Created by Sam on 2019/10/26.
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Classroom {
    private Integer id;
    @NonNull
    private String name;
    private Set<Student> students;

    public Classroom(String name, Set<Student> students) {
        this.name = name;
        this.students = students;
    }
}
