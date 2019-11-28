package com.yangzg.hibernate.model9;

import lombok.*;

import java.util.Set;

/**
 * Created by Sam on 2019/10/29.
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = "teachers")
@ToString(exclude = "teachers")
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
