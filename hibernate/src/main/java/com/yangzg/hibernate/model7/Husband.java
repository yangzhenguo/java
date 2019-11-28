package com.yangzg.hibernate.model7;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created by Sam on 2019/10/28.
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Husband {
    private Integer id;
    @NonNull
    private String name;
    private Wife wife;

    public Husband(String name, Wife wife) {
        this.name = name;
        this.wife = wife;
    }
}
