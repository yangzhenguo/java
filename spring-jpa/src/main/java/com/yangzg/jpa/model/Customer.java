package com.yangzg.jpa.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Sam on 2019/12/6.
 */
@Data
@Entity
@Table(name = "JPA_CUSTOMERS")
@NamedQueries({
        @NamedQuery(name = "countCustomerWithCriteria", query = "select count(c) from Customer c where c.id = :id")
})
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String name;
//    @Temporal(TemporalType.DATE)
    @NonNull
    private LocalDate birthday;
}
