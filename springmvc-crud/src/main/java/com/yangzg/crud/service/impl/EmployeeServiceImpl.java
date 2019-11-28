package com.yangzg.crud.service.impl;

import com.yangzg.crud.dao.EmployeeDao;
import com.yangzg.crud.model.Employee;
import com.yangzg.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Sam on 2019/11/24.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional(readOnly = true)
    public Optional<Employee> getByUid(final String uid) {
        return this.employeeDao.selectByUid(uid);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> listAll() {
        return this.employeeDao.selectAll();
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        if (StringUtils.isEmpty(employee.getUid())) {
            employee.setUid(UUID.randomUUID().toString());
            this.employeeDao.insert(employee);
        } else {
            this.employeeDao.update(employee);
        }
    }

    @Override
    @Transactional
    public void removeByUid(String uid) {
        this.employeeDao.deleteByUid(uid);
    }
}
