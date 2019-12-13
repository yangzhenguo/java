package com.yangzg.dj.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Created by Sam on 2019/12/13.
 */
@Table
@Entity
@Data
public class User {
    @Id
    private String uid;

    private String username;

    private String password;

    private String name;

    private String email;

    private String telephone;

    private LocalDate birthday;

    private String sex;

    private Integer state;

    private String code;
}
