package com.yangzg.hibernate.model1;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * Created by Sam on 2019/10/27.
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Husband {
    public Husband(String name, Wife wife) {
        this.name = name;
        this.wife = wife;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String name;
    @ManyToOne
    @JoinColumn
    private Wife wife;
}
