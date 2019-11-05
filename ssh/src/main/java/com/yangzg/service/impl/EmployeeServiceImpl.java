package com.yangzg.service.impl;

import com.yangzg.dao.inf.EmployeeDao;
import com.yangzg.model.Employee;
import com.yangzg.service.inf.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sam on 2019/11/5.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public List<Employee> listAll() {
        return this.employeeDao.queryAll();
    }
}
