package com.yangzg.service.inf;

import com.yangzg.model.Employee;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/11/5.
 */
public interface EmployeeService {
    List<Employee> listAll();

    void delete(final int id);

    Employee create(final Employee employee);

    Optional<Employee> get(int id);

    Optional<Employee> edit(final Employee employee);
}
