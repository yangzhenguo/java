package com.yangzg.crud.service;

import com.yangzg.crud.model.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/11/24.
 */
public interface EmployeeService {
    Optional<Employee> getByUid(final String uid);

    List<Employee> listAll();

    void save(Employee employee);

    @Transactional
    void save2(Employee employee1, Employee employee2);

    void removeByUid(String uid);
}
