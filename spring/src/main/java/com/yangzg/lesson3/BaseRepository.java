package com.yangzg.lesson3;

/**
 * Created by Sam on 2020/3/19.
 */
public abstract class BaseRepository<T> {
    abstract T getById(final long id);
}
