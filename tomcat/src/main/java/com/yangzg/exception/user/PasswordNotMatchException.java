package com.yangzg.exception.user;

import com.yangzg.exception.UserException;

/**
 * Created by Sam on 2019/9/20.
 */
public class PasswordNotMatchException extends UserException {
    private static final long serialVersionUID = 2828643671963201749L;

    public PasswordNotMatchException(String message) {
        super(message);
    }

    public PasswordNotMatchException() {
        super("密码不正确");
    }
}
