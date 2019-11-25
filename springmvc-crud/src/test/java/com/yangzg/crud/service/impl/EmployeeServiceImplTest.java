package com.yangzg.crud.service.impl;

import com.yangzg.crud.config.RootConfig;
import com.yangzg.crud.model.Employee;
import com.yangzg.crud.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Sam on 2019/11/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class EmployeeServiceImplTest {
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void listAll() throws Exception {
        final List<Employee> employees = this.employeeService.listAll();
        employees.forEach(System.out::println);
    }

}