package com.yangzg.hibernate.model1;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Sam on 2019/10/27.
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "`number`")
    private String number;

    @ManyToOne
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "person_id_fk"))
    private Person person;

    public Phone(String number, Person person) {
        this.number = number;
        this.person = person;
    }
}
