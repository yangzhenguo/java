package com.yangzg.dao.inf;

import com.yangzg.model.Employee;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/11/5.
 */
public interface EmployeeDao {
    List<Employee> queryAll();

    void deleteById(final int id);

    Optional<Employee> update(Employee employee);

    Employee save(Employee employee);

    Optional<Employee> selectById(final int id);
}
