package com.yangzg.hibernate.model4;

import lombok.*;

import java.util.Set;

/**
 * Created by Sam on 2019/10/26.
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = "orders")
@ToString(exclude = "orders")
public class Customer {
    private Integer id;
    @NonNull
    private String name;
    private Set<Order> orders;
}
