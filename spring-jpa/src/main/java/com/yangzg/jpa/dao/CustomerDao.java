package com.yangzg.jpa.dao;

import com.yangzg.jpa.model.Customer;

import java.util.Optional;

/**
 * Created by Sam on 2019/12/6.
 */
public interface CustomerDao {
    Optional<Customer> first();

    void insert(Customer customer);
}
