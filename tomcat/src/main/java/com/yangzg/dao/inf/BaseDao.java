package com.yangzg.dao.inf;

/**
 * Created by Sam on 2019/9/23.
 */
public interface BaseDao<T> {
    boolean insert(String sql, T entity);
}
