package com.yangzg.crud.model;

import lombok.Data;

/**
 * Created by Sam on 2019/11/28.
 */
@Data
public class Customer {
    private String firstName;
    private String lastName;
    private Address address;
}
