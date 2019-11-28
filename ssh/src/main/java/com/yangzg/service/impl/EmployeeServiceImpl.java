package com.yangzg.service.impl;

import com.yangzg.dao.inf.EmployeeDao;
import com.yangzg.model.Employee;
import com.yangzg.service.inf.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/11/5.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> listAll() {
        return this.employeeDao.queryAll();
    }

    @Override
    @Transactional
    public void delete(int id) {
        this.employeeDao.deleteById(id);
    }

    @Override
    @Transactional
    public Employee create(Employee employee) {
        return this.employeeDao.save(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Employee> get(int id) {
        return this.employeeDao.selectById(id);
    }

    @Override
    @Transactional
    public Optional<Employee> edit(Employee employee) {
        return this.employeeDao.update(employee);
    }
}
