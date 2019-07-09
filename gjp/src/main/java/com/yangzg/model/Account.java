package com.yangzg.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by Sam on 2019/7/9.
 */
@Data
public class Account {
    private Integer id;
    private String category;
    private String name;
    private Double price;
    private String description;
    private Date createDate;
}
