package com.yangzg.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by Sam on 2019/11/5.
 */
@Data
public class Employee {
    private Integer id;
    private String name;
    private Date createTime;
    private Department department;
}
