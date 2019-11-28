package com.yangzg.service.inf;

import com.yangzg.exception.UserException;
import com.yangzg.model.User;

import java.util.List;

/**
 * Created by Sam on 2019/9/20.
 */
public interface UserService {
    List<User> listAll();

    boolean login(String username, String password) throws UserException;
}
