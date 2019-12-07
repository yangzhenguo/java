package com.yangzg.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by Sam on 2019/12/7.
 */
@Data
@Entity
public class Employee {
    @Id
    private String uid;
    private String username;
    private String password;
    private String name;
    private String email;
    private String telephone;
    private LocalDate birthday;
    private String sex;
    private Boolean state;
    private String code;
}
