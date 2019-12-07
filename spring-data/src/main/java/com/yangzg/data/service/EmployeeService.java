package com.yangzg.data.service;

import com.yangzg.data.entity.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/12/7.
 */
public interface EmployeeService {
    Optional<Employee> getByUid(String uid);

    List<Employee> getAllByBirthdayBefore(LocalDate currentDate);
}
