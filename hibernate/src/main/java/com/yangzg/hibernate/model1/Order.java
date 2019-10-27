package com.yangzg.hibernate.model1;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created by Sam on 2019/10/26.
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Order {
    private Integer id;
    @NonNull
    private String name;
    private Customer customer;

    public Order(String name, Customer customer) {
        this.name = name;
        this.customer = customer;
    }
}
