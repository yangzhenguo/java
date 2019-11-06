package com.yangzg.dao.impl;

import com.yangzg.dao.inf.DepartmentDao;
import com.yangzg.dao.inf.EmployeeDao;
import com.yangzg.model.Department;
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
public class DepartmentDaoImpl extends BaseDao implements DepartmentDao {
    @Override
    public List<Department> queryAll() {
        return this.getSession().createQuery("from Department").list();
    }
}
