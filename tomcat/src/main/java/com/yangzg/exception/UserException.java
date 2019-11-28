package com.yangzg.exception;

/**
 * Created by Sam on 2019/9/20.
 */
public abstract class UserException extends Exception {
    private static final long serialVersionUID = 4073555874900140806L;

    public UserException(String message) {
        super(message);
    }

    public UserException() {
    }
}
