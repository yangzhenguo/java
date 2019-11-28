package com.yangzg.hibernate.model8;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created by Sam on 2019/10/29.
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Teacher {
    private Integer id;
    @NonNull
    private String name;
}
