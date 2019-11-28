package com.yangzg.dao.inf;

import com.yangzg.model.Department;

import java.util.List;

/**
 * Created by Sam on 2019/11/5.
 */
public interface DepartmentDao {
    List<Department> queryAll();
}
