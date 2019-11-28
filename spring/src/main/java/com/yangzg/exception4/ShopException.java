package com.yangzg.exception4;

/**
 * Created by Sam on 2019/11/2.
 */
public class ShopException extends RuntimeException {
    public ShopException() {
    }

    public ShopException(String message) {
        super(message);
    }

    public ShopException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShopException(Throwable cause) {
        super(cause);
    }

    public ShopException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
