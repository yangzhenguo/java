package com.yangzg.dao.impl;

import com.yangzg.dao.inf.EmployeeDao;
import com.yangzg.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/11/5.
 */
@Repository
public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {
    @Override
    public List<Employee> queryAll() {
        return this.getSession().createQuery("from Employee p left outer join fetch p.department order by p.id").list();
    }

    @Override
    public void deleteById(int id) {
        this.getSession().createQuery("delete from Employee p where p.id = :id").setParameter("id", id).executeUpdate();
    }

    @Override
    public Optional<Employee> update(Employee employee) {
        final Employee model = this.getSession().get(Employee.class, employee.getId());
        model.setDepartment(employee.getDepartment());
        model.setName(employee.getName());
        return Optional.of(model);
    }

    @Override
    public Employee save(Employee employee) {
        this.getSession().save(employee);
        return employee;
    }

    @Override
    public Optional<Employee> selectById(int id) {
        return this.getSession().createQuery("from Employee e left join fetch e.department where e.id = :id").setParameter("id", id).uniqueResultOptional();
    }
}
