package com.yangzg.util;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Sam on 2019/7/9.
 */
public final class JDBCUtil {
    private JDBCUtil() {}

    private static final DataSource DATA_SOURCE;

    private static final QueryRunner QUERY_RUNNER;

    static {
        try {
            final Properties properties = new Properties();
            properties.setProperty("url", "jdbc:mysql://localhost/gjp?useUnicode=true&characterEncoding=UTF-8");
            properties.setProperty("username", "root");
            properties.setProperty("password", "root");
            DATA_SOURCE = BasicDataSourceFactory.createDataSource(properties);
            QUERY_RUNNER = new QueryRunner(DATA_SOURCE);
        } catch (Exception e) {
            e.printStackTrace();
            throw new  RuntimeException(e);
        }
    }

    public static QueryRunner getQueryRunner() {
        return QUERY_RUNNER;
    }
}
