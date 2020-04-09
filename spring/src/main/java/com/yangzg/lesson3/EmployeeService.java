package com.yangzg.lesson3;

/**
 * Created by Sam on 2020/3/19.
 */
public class EmployeeService extends BaseService<Employee> {
    @Override
    Employee get(final long id) {
        return this.baseRepository.getById(id);
    }
}
