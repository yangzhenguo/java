package com.hiyzg.exception;

/**
 * Created by Sam on 2019/10/4.
 */
public class NoPermissionException extends RuntimeException {
    private static final long serialVersionUID = 7699163298172776633L;

    public NoPermissionException() {
    }

    public NoPermissionException(String message) {
        super(message);
    }
}
