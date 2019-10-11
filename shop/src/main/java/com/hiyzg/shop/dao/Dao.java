package com.hiyzg.shop.dao;

import java.util.Optional;

/**
 * Created by Sam on 2019/10/11.
 */
public interface Dao<T> {
    long insert(String sql, Object... params);

    boolean deleteById(final long id);

    boolean update(T t);

    long count(String sql, Object... params);

    Optional<T> selectById(String sql, long id);
}
