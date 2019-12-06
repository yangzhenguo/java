package com.yangzg.jpa.model;

import lombok.Data;
import org.hibernate.jpa.QueryHints;

import javax.persistence.*;

/**
 * Created by Sam on 2019/12/5.
 */
@Data
@Entity
@Table(name = "JPA_ORDERS")
@NamedQueries({
        @NamedQuery(name = "selectAllOrder", query = "from Order o left join fetch o.customer", hints = @QueryHint(name = QueryHints.HINT_CACHEABLE, value = "true"))
})
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @JoinColumn
    @ManyToOne
    private Customer customer;
}
