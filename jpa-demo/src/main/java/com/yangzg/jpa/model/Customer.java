package com.yangzg.jpa.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Sam on 2019/12/4.
 */
@Data
@Entity
@Table(name = "JPA_CUSTOMERS")
@ToString(exclude = "orders")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
