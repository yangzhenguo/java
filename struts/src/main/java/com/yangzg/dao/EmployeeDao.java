package com.yangzg.dao;

import com.yangzg.model.Department;
import com.yangzg.model.Employee;
import com.yangzg.model.Role;

import java.time.LocalTime;
import java.util.*;

/**
 * Created by Sam on 2019/10/21.
 */
public class EmployeeDao {
    private static final Map<Integer, Employee> EMPLOYEE_MAP = new HashMap<Integer, Employee>(){
        private static final long serialVersionUID = -2535121324961592713L;

        {
            put(1001, new Employee(1001, "AA", "aa", "aa@emp.com"));
            put(1002, new Employee(1002, "BB", "bb", "bb@emp.com"));
            put(1003, new Employee(1003, "CC", "cc", "cc@emp.com"));
            put(1004, new Employee(1004, "DD", "dd", "dd@emp.com"));
            put(1005, new Employee(1005, "EE", "ee", "cc@emp.com"));
        }
    };

    public List<Employee> getEmployees() {
        return new ArrayList<>(EMPLOYEE_MAP.values());
    }

    public boolean delete(int id) {
        return EMPLOYEE_MAP.remove(id) != null;
    }

    public boolean insert(Employee employee) {
        return EMPLOYEE_MAP.put(LocalTime.now().getSecond(), employee) != null;
    }

    public void update(Employee employee) {
        EMPLOYEE_MAP.put(employee.getId(), employee);
    }

    public List<Department> getDepartments() {
        return Arrays.asList(
                new Department(1, "dept1"),
                new Department(2, "dept2"),
                new Department(3, "dept3")
        );
    }

    public List<Role> getRoles() {
        return Arrays.asList(
                new Role(1, "role1"),
                new Role(2, "role2"),
                new Role(3, "role3")
        );
    }
}
