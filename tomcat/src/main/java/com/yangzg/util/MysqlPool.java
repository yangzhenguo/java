package com.yangzg.util;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Sam on 2019/9/20.
 */
public class MysqlPool {
    private static volatile DataSource dataSource = null;

    public static DataSource getDataSource() {
        if (dataSource == null)
        synchronized (MysqlPool.class) {
            try {
                if (dataSource == null) {
                    Properties properties = new Properties();
                    InputStream stream = MysqlPool.class.getClassLoader().getResourceAsStream("jdbc.properties");
                    properties.load(stream);
                    dataSource = BasicDataSourceFactory.createDataSource(properties);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return dataSource;
    }
}
