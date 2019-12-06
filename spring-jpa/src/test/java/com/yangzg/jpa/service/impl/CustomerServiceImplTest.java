package com.yangzg.jpa.service.impl;

import com.yangzg.jpa.config.BasicConfig;
import com.yangzg.jpa.model.Customer;
import com.yangzg.jpa.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Sam on 2019/12/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BasicConfig.class)
public class CustomerServiceImplTest {
    @Autowired
    private CustomerService customerService;

    @Test
    public void getFirst() throws Exception {
        this.customerService.getFirst().ifPresent(System.out::println);
    }

    @Test
    public void save() throws Exception {
        final Customer customer = new Customer("yzg1", LocalDate.now());
        this.customerService.save(customer);
        System.out.println(customer);
    }

    @Test
    public void batchSave() throws Exception {
        final List<Customer> customers = IntStream.rangeClosed(1, 2).boxed().map(num -> new Customer("yzg" + num, LocalDate.now())).collect(Collectors.toList());
        System.out.println(customers);
        this.customerService.save(customers);
        System.out.println(customers);
    }
}