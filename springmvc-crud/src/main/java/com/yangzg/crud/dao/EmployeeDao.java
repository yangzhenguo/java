package com.yangzg.crud.dao;

import com.yangzg.crud.model.Employee;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/11/24.
 */
public interface EmployeeDao {
    Optional<Employee> selectByUid(String uid);

    List<Employee> selectAll();

    void insert(Employee employee);

    void deleteByUid(String uid);
}
