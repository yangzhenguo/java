package com.yangzg.lambda.strategy;

import com.yangzg.lambda.Employee;
import com.yangzg.lambda.MyPredicate;

/**
 * Created by Sam on 2019/9/3.
 */
public class BySalaryFilterStrategy implements MyPredicate<Employee> {
    private final double salary;

    public BySalaryFilterStrategy(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >= this.salary;
    }
}
