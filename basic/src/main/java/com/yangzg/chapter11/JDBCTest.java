package com.yangzg.chapter11;

import lombok.Cleanup;

import java.io.IOException;
import java.sql.*;
import java.util.Optional;
import java.util.Properties;

/**
 * Created by Sam on 2019/7/6.
 */
public class JDBCTest {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    private static void test4() {

    }

    private static void test3() {
        try {
            Properties properties = new Properties();
            properties.load(JDBCTest.class.getResourceAsStream("/jdbc.properties"));
            @Cleanup
            Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);
            @Cleanup
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USERS");
            @Cleanup
            ResultSet resultSet = preparedStatement.executeQuery();
            Optional.of(resultSet.next()).filter(flag -> flag).ifPresent(b -> {
                try {
                    System.out.println(resultSet.getString(1));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void test2() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            @Cleanup
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gjp?useSSL=false", "root", "root");
            @Cleanup
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USERS");
            @Cleanup
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
            preparedStatement.execute("", new String[]{""});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void test1() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gjp", "root", "root");
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USERS");
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            System.out.println(resultSet);
            while (resultSet.next()) {
                String string = resultSet.getString(1);
                System.out.println(string);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
