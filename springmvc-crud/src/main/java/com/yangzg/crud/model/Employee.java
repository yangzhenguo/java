package com.yangzg.crud.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * Created by Sam on 2019/11/24.
 */
@Data
public class Employee {
    private String uid;
    @NotBlank
    private String username;
    private String password;
    private String name;
    private String email;
    private String telephone;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String sex;
    private Boolean state;
    private String code;
}
