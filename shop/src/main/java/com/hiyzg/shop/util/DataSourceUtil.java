package com.hiyzg.shop.util;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Sam on 2019/10/11.
 */
public class DataSourceUtil {
    private static volatile DataSource dataSource;

    private DataSourceUtil() {}

    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (DataSourceUtil.class) {
                if (dataSource == null) {
                    try {
                        final Properties properties = new Properties();
                        properties.load(DataSourceUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
                        dataSource = BasicDataSourceFactory.createDataSource(properties);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return dataSource;
    }
}
