package com.yangzg.data.service.impl;

import com.yangzg.data.config.BasicConfig;
import com.yangzg.data.repository.EmployeeRepository;
import com.yangzg.data.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;

/**
 * Created by Sam on 2019/12/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BasicConfig.class)
public class EmployeeServiceImplTest {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void getByUid() throws Exception {
        this.employeeService.getByUid("373eb242933b4f5ca3bd43503c34668b").ifPresent(System.out::println);
    }

    @Test
    public void getAllByBirthdayBefore() throws Exception {
        this.employeeService.getAllByBirthdayBefore(LocalDate.now()).forEach(System.out::println);
    }

    public void findAllPager() {
        this.employeeRepository.findAll(Example.of(null, ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatcher::contains)));
    }
}