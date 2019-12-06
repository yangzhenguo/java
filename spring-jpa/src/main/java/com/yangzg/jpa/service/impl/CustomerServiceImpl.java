package com.yangzg.jpa.service.impl;

import com.yangzg.jpa.dao.CustomerDao;
import com.yangzg.jpa.model.Customer;
import com.yangzg.jpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/12/6.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public Optional<Customer> getFirst() {
        return this.customerDao.first();
    }

    @Override
    @Transactional
    public void save(Customer customer) {
        this.customerDao.insert(customer);
    }

    @Override
    @Transactional
    public void save(List<Customer> customers) {
        for (Customer customer: customers) {
            if (customer.getName().equals("yzg4")) throw new RuntimeException("error");
            this.customerDao.insert(customer);
        }
    }
}
