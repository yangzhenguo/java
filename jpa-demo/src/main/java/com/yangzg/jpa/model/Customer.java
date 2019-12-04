package com.yangzg.jpa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sam on 2019/12/4.
 */
@Data
@Entity
@Table(name = "CUSTOMERS")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date birthday;
}
