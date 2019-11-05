package com.yangzg.dao.impl;

import com.yangzg.dao.inf.EmployeeDao;
import com.yangzg.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sam on 2019/11/5.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Employee> queryAll() {
        return this.getSession().createQuery("from Employee p left outer join fetch p.department").list();
    }
}
