package com.yangzg.service.impl;

import com.yangzg.dao.impl.UserDaoImpl;
import com.yangzg.dao.inf.UserDao;
import com.yangzg.exception.UserException;
import com.yangzg.exception.user.PasswordNotMatchException;
import com.yangzg.exception.user.UserNotExistsException;
import com.yangzg.model.User;
import com.yangzg.service.inf.UserService;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/9/20.
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> listAll() {
        try {
            return this.userDao.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public boolean login(String username, String password) throws UserException {
        Optional<User> userOptional = this.userDao.selectByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(password)) {
                return true;
            } else {
                throw new PasswordNotMatchException();
            }
        }
        throw new UserNotExistsException();
    }
}
