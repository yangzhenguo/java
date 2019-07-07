package com.yangzg.chapter11;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Sam on 2019/7/7.
 */
public class JDBCUtil {
    private static Properties properties;

    private JDBCUtil() {}

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            properties = new Properties();
            properties.load(JDBCUtil.class.getResourceAsStream("/jdbc.properties"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <E> List<E> queryList(String sql, Class<E> clazz, Object... parameters) {
        Connection connection = null;
        try {
            connection = openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            IntStream.range(0, parameters.length).forEach(index -> setDBParameter(preparedStatement, index + 1, parameters[index]));
            ResultSet resultSet = preparedStatement.executeQuery();
            Map<String, Field> mapping = Arrays.stream(clazz.getDeclaredFields()).filter(field -> field.isAnnotationPresent(Column.class)).map(field -> new HashMap.SimpleImmutableEntry(field.getAnnotation(Column.class).value(), field)).collect(Collectors.toMap(entry -> (String) entry.getKey(), entry -> (Field) entry.getValue()));
            List<E> result = new ArrayList<>();
            while (resultSet.next()) {
                E instance = clazz.newInstance();
                for (Map.Entry<String, Field> entry: mapping.entrySet()) {
                    Field value = entry.getValue();
                    value.setAccessible(true);
                    value.set(instance, getDBValue(resultSet, entry));
                    value.setAccessible(false);
                }
                result.add(instance);
            }
            return result;
        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeQuietly(connection);
        }
    }

    private static void setDBParameter(PreparedStatement preparedStatement, int index, Object value) {
        try {
            if (value instanceof CharSequence) {
                preparedStatement.setString(index, (String) value);
            } else if (value instanceof Integer) {
                preparedStatement.setInt(index, (Integer) value);
            } else {
                preparedStatement.setObject(1, value);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static Object getDBValue(ResultSet resultSet, Map.Entry<String, Field> entry) throws SQLException {
        if (entry.getValue().getType() == Integer.class) {
            return resultSet.getInt(entry.getKey());
        } else if (entry.getValue().getType() == String.class) {
            return resultSet.getString(entry.getKey());
        } else {
            return resultSet.getObject(entry.getKey());
        }
    }

    private static Connection openConnection() throws SQLException {
        return DriverManager.getConnection(properties.getProperty("url"), properties);
    }

    private static void closeQuietly(AutoCloseable... resources) {
        try {
            for (AutoCloseable t: resources) {
                if (t != null) {
                    t.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
