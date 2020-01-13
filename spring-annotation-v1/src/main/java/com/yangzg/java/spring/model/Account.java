package com.yangzg.java.spring.model;

import lombok.Data;

/**
 * Created by Sam on 2020/1/13.
 * @author Sam
 */
@Data
public class Account {
    private String id;
    private String name;
    private String email;
    private String password;
    private boolean activated;
}
