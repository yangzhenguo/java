package com.hiyzg.shop.dao.impl;

import com.hiyzg.shop.dao.Dao;
import com.hiyzg.shop.util.DataSourceUtil;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Sam on 2019/10/11.
 */
public abstract class BaseDao<T> implements Dao<T> {
    private QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());

    private Class<T> clazz;

    public BaseDao() {
        final Type type = this.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            clazz = (Class<T>)((ParameterizedType)type).getActualTypeArguments()[0];
        } else {
            clazz = (Class<T>) type;
        }
    }

    @Override
    public long insert(String sql, Object... params) {
        try {
            return queryRunner.insert(sql, new ScalarHandler<Long>(), params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public boolean update(T t) {
        return false;
    }

    @Override
    public long count(String sql, Object... params) {
        try {
            return queryRunner.query(sql, new ScalarHandler<Long>(), params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<T> selectById(String sql, long id) {
        try {
            return Optional.ofNullable(this.queryRunner.query(sql, new BeanHandler<T>(clazz, new BasicRowProcessor(new BeanProcessor(this.getColumnToPropertyOverrides()))), id));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    protected Map<String,String> getColumnToPropertyOverrides() {
        return Collections.EMPTY_MAP;
    }

    public Class<T> getClazz() {
        return clazz;
    }
}
