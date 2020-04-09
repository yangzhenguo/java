package com.yangzg.lesson3;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Sam on 2020/3/19.
 */
public abstract class BaseService<T> {
    @Autowired
    protected BaseRepository<T> baseRepository;

    abstract Employee get(final long id);
}
