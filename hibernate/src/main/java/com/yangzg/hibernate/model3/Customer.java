package com.yangzg.hibernate.model3;

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
public class Customer {
    private Integer id;
    @NonNull
    private String name;
    private Set<Order> orders;
}
