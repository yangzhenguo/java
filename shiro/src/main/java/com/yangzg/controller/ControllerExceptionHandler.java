package com.yangzg.controller;

import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sam on 2019/6/25.
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(value=AuthenticationException.class)
    public String handleServiceException(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        ResponseEntity<String> stringResponseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.OK);
        return "redirect:/";
    }

    @ExceptionHandler(value=Exception.class)
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Exception exception, HttpServletRequest request) {
        logger.error("系统异常!", exception);
        return new ResponseEntity<String>("操作失败，请联系管理员！", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public ResponseEntity<String> handle404Exception() {
        return new ResponseEntity<String>("Not found", HttpStatus.NOT_FOUND);
    }
}
