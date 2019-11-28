package com.yangzg.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;

/**
 * Created by Sam on 2019/7/9.
 */
public final class JDBCUtil {
    private JDBCUtil() {}

    private static final DataSource DATA_SOURCE;

    private static final QueryRunner QUERY_RUNNER;

    static {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost/gjp?useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUser("root");
        dataSource.setPassword("1qaz1QAZ2wsx2WSX");
        DATA_SOURCE = dataSource;
        QUERY_RUNNER = new QueryRunner(DATA_SOURCE);
    }

    public static QueryRunner getQueryRunner() {
        return QUERY_RUNNER;
    }
}
