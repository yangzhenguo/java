package com.yangzg.jdbc1;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Sam on 2020/3/26.
 */
public class Jdbc1Test {
    @Test
    public void test1() throws Exception {
        try (final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/book?useUnicode=true&characterEncoding=UTF-8&useSSL=false", "sam", "sam")) {
            System.out.println(connection.getMetaData());
        }
    }

    @Test
    public void test2() throws Exception {
        final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/book?useUnicode=true&characterEncoding=UTF-8&useSSL=false", "sam", "sam");
        System.out.println(connection.getMetaData());
    }
}