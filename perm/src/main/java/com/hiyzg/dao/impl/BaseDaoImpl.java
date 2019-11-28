package com.hiyzg.dao.impl;

import com.hiyzg.annotation.Column;
import com.hiyzg.annotation.Table;
import com.hiyzg.dao.BaseDao;
import com.hiyzg.util.MysqlUtil;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Sam on 2019/9/30.
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
    private Class<T> clazz;
    private String tableName;

    public BaseDaoImpl() {
        final Type type = this.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            final ParameterizedType parameterizedType = (ParameterizedType) type;
            clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
            if (this.clazz.isAnnotationPresent(Table.class)) {
                tableName = this.clazz.getAnnotation(Table.class).value();
            } else {
                tableName = this.clazz.getSimpleName().toLowerCase();
            }
        } else {
            throw new RuntimeException("must extends BaseDaoImpl<T>");
        }
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public String getTableName() {
        return tableName;
    }

    public Map<String, String> columnToPropertyOverrides() {
        return new HashMap<String, String>(){
            private static final long serialVersionUID = 1L;

            {
                final Map<String, String> map = Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toMap(field -> {
                    if (field.isAnnotationPresent(Column.class)) {
                        return field.getAnnotation(Column.class).value();
                    } else {
                        return field.getName();
                    }
                }, Field::getName));
                putAll(map);
            }
        };
    }

    protected QueryRunner queryRunner = new QueryRunner(MysqlUtil.getDataSource());

    public Optional<T> findById(int id) {
        try {
            return Optional.ofNullable(this.queryRunner.query(String.format("select * from %s where id = ?", this.tableName), new BeanHandler<T>(this.clazz, new BasicRowProcessor(new BeanProcessor(this.columnToPropertyOverrides()))), id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<T> findAll() {
        try {
            return this.queryRunner.query(String.format("select * from %s", this.getTableName()), new BeanListHandler<T>(this.clazz));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
