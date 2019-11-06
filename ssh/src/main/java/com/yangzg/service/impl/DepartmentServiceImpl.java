package com.yangzg.service.impl;

import com.yangzg.dao.inf.DepartmentDao;
import com.yangzg.model.Department;
import com.yangzg.service.inf.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sam on 2019/11/5.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    @Transactional(readOnly = true)
    public List<Department> listAll() {
        return this.departmentDao.queryAll();
    }
}
