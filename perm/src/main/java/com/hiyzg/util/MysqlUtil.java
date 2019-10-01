package com.hiyzg.util;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Sam on 2019/9/30.
 */
public class MysqlUtil {
    private static final DataSource DATA_SOURCE;

    static {
        try {
            final Properties prop = new Properties();
            prop.load(MysqlUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            DATA_SOURCE = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource() {
        return DATA_SOURCE;
    }
}
