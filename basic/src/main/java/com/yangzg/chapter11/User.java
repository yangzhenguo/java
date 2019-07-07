package com.yangzg.chapter11;

import lombok.Data;

/**
 * Created by Sam on 2019/7/7.
 */
@Data
public class User {
    @Column("id")
    private Integer id;

    @Column("username")
    private String username;

    @Column("password")
    private String password;

    @Column("description")
    private String desc;
}
