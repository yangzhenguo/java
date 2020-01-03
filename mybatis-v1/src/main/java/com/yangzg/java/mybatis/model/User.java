package com.yangzg.java.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sam on 2020/1/1.
 * @author Sam
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String username;

    public User(String username) {
        this.username = username;
    }
}
