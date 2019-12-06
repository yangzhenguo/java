package com.yangzg.jpa.service;

import com.yangzg.jpa.model.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/12/6.
 */
public interface CustomerService {
    Optional<Customer> getFirst();

    void save(Customer customer);

    @Transactional
    void save(List<Customer> customers);
}
