package com.yangzg.lesson3;

/**
 * Created by Sam on 2020/3/19.
 */
public class EmployeeRepository extends BaseRepository<Employee> {
    @Override
    Employee getById(long id) {
        return new Employee();
    }
}
