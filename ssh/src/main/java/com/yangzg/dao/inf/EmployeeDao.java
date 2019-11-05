package com.yangzg.dao.inf;

import com.yangzg.model.Employee;

import java.util.List;

/**
 * Created by Sam on 2019/11/5.
 */
public interface EmployeeDao {
    List<Employee> queryAll();
}
