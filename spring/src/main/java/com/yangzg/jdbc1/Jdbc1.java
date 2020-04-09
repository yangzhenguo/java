package com.yangzg.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sam on 2020/3/26.
 */
public class Jdbc1 {
    public static void main(String[] args) throws InterruptedException {
        try(final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/book?useUnicode=true&characterEncoding=UTF-8&useSSL=false", "sam", "sam")) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
        TimeUnit.SECONDS.sleep(100);
    }
}
