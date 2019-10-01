package com.hiyzg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Sam on 2019/9/30.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authority {
    private Integer id;
    private String name;
    private String url;
    private List<User> users;
}
