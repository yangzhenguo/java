package com.yangzg.lesson3;

import lombok.Data;

import java.util.Date;

/**
 * Created by Sam on 2020/3/18.
 */
@Data
public class Employee {
    private String uid;
    private String username;
    private String password;
    private String name;
    private String email;
    private String telephone;
    private Date birthday;
    private Integer sex;
    private Integer state;
    private String code;
}
