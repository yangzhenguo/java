package com.yangzg.chapter12;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Sam on 2019/7/8.
 */
public class DbUtilTest {
    public static final Logger LOGGER = LoggerFactory.getLogger(DbUtilTest.class);

    private static MysqlDataSource dataSource = new MysqlDataSource();
    private static QueryRunner queryRunner = new QueryRunner(dataSource);

    static {
        try {
            Properties properties = new Properties();
            properties.load(DbUtilTest.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            dataSource.setUser(properties.getProperty("user"));
            dataSource.setPassword(properties.getProperty("password"));
            dataSource.setURL(properties.getProperty("url"));
        } catch (IOException e) {
            LOGGER.error(e.toString());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    private static void test3() {
        try {
            List<Integer> ids = queryRunner.query("select id from users", new ColumnListHandler<Integer>("id"));
            System.out.println(ids);

            List<String> descriptions = queryRunner.query("select * from users", new ColumnListHandler<String>("description"));
            System.out.println(descriptions);
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error(e.toString());
        }
    }

    private static void test2() {
        try {
            Optional<User> userOptional = Optional.ofNullable(queryRunner.query("select * from users", new BeanHandler<>(User.class, new BasicRowProcessor(new BeanProcessor(new HashMap<String, String>() {
                private static final long serialVersionUID = -3689952691541855059L;

                {
                    put("description", "desc");
                }
            })))));
            userOptional.ifPresent(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error(e.toString());
        }
    }

    private static void test1() {
        try {
            List<Object[]> query = queryRunner.query("select * from users", new ArrayListHandler());
            query.forEach(bean -> Arrays.stream(bean).forEach(System.out::println));
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error(e.toString());
        }
    }
}
