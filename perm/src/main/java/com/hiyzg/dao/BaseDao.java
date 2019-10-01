package com.hiyzg.dao;

import java.util.Optional;

/**
 * Created by Sam on 2019/9/30.
 */
public interface BaseDao<T> {
    Optional<T> findById(int id);
}
