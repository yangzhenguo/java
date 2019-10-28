package com.yangzg.hibernate.model6;

import lombok.*;

/**
 * Created by Sam on 2019/10/28.
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = "husband")
@ToString(exclude = "husband")
public class Wife {
    private Integer id;
    @NonNull
    private String name;
    private Husband husband;

    public Wife(String name, Husband husband) {
        this.name = name;
        this.husband = husband;
    }
}
