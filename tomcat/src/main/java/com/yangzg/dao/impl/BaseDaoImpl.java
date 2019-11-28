package com.yangzg.dao.impl;

import com.yangzg.annotation.MysqlField;
import com.yangzg.dao.inf.BaseDao;
import com.yangzg.util.MysqlPool;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Sam on 2019/9/23.
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
    private Class<T> clazz;

    private final Map<String, String> columnToPropertyOverrides;

    private final Map<String, String> propertyToColumnMapping;

    protected QueryRunner queryRunner = new QueryRunner(MysqlPool.getDataSource());

    public BaseDaoImpl() {
        Type type = this.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.clazz = (Class<T>)parameterizedType.getActualTypeArguments()[0];
        }
        columnToPropertyOverrides = Arrays.stream(this.clazz.getFields()).filter(filed -> filed.isAnnotationPresent(MysqlField.class)).collect(Collectors.toMap(field -> field.getAnnotation(MysqlField.class).value(), Field::getName));
        propertyToColumnMapping = new HashMap<String, String>() {
            private static final long serialVersionUID = 1L;

            {
                putAll(Arrays.stream(clazz.getFields()).collect(Collectors.toMap(Field::getName, Field::getName)));
                putAll(columnToPropertyOverrides.entrySet().stream().collect(Collectors.toMap(Entry::getValue, Entry::getKey)));
            }
        };
    }

    @Override
    public boolean insert(String sql, T entity) {
        try {
            this.queryRunner.insert(sql, new BeanHandler<T>(this.clazz, new BasicRowProcessor(new BeanProcessor(columnToPropertyOverrides))));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
