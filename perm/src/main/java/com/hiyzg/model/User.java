package com.hiyzg.model;

import com.hiyzg.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Sam on 2019/9/30.
 */
@Table("user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private List<Authority> authorities;
}
