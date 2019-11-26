package com.yangzg.crud.model;

import lombok.Data;

/**
 * Created by Sam on 2019/11/24.
 */
@Data
public class Employee {
    private String uid;
    private String username;
    private String password;
    private String name;
    private String email;
    private String telephone;
//    private Date birthday;
    private String sex;
    private Boolean state;
    private String code;
}
