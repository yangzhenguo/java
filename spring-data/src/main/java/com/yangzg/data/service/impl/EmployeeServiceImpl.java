package com.yangzg.data.service.impl;

import com.yangzg.data.entity.Employee;
import com.yangzg.data.repository.EmployeeRepository;
import com.yangzg.data.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/12/7.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> getByUid(String uid) {
        return this.employeeRepository.getByUid(uid);
    }

    @Override
    public List<Employee> getAllByBirthdayBefore(LocalDate currentDate) {
        return this.employeeRepository.findAllByBirthdayBefore(currentDate);
    }
}
