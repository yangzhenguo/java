package com.yangzg.crud.dao.impl;

import com.yangzg.crud.config.RootConfig;
import com.yangzg.crud.dao.EmployeeDao;
import com.yangzg.crud.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/11/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class EmployeeDaoImplTest {
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void selectAll() throws Exception {
        final List<Employee> employees = this.employeeDao.selectAll();
        employees.forEach(System.out::println);
    }

    @Test
    public void getByUid1() {
        final Optional<Employee> employeeOptional = this.employeeDao.selectByUid("74ab553996ae497296f0b88901bf8bfc");
        employeeOptional.ifPresent(System.out::println);
    }

    @Test
    public void getByUid2() {
        final Optional<Employee> employeeOptional = this.employeeDao.selectByUid("");
        employeeOptional.ifPresent(System.out::println);
    }
}