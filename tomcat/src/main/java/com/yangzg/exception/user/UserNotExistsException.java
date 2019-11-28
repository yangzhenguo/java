package com.yangzg.exception.user;

import com.yangzg.exception.UserException;

/**
 * Created by Sam on 2019/9/20.
 */
public class UserNotExistsException extends UserException {
    private static final long serialVersionUID = -3153748496264358721L;

    public UserNotExistsException(String message) {
        super(message);
    }

    public UserNotExistsException() {
        super("用户不存在");
    }
}
