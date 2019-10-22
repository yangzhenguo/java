package com.yangzg.dao;

import com.yangzg.model.Employee;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        final int id = (int)LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        employee.setId(id);
        return EMPLOYEE_MAP.put(id, employee) != null;
    }

    public void update(Employee employee) {
        EMPLOYEE_MAP.put(employee.getId(), employee);
    }

    public Employee get(int id) {
        return EMPLOYEE_MAP.get(id);
    }
}
