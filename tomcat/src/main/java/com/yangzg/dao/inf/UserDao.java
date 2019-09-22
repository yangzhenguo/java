package com.yangzg.dao.inf;

import com.yangzg.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/9/20.
 */
public interface UserDao {
    List<User> selectAll() throws SQLException;

    Optional<User> selectByUsername(String username);
}
