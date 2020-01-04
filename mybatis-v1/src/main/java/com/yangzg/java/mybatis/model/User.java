package com.yangzg.java.mybatis.model;

import lombok.*;
import org.apache.ibatis.type.Alias;

/**
 * Created by Sam on 2020/1/1.
 * @author Sam
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Alias("user")
public class User {
    @NonNull
    private int id;
    @NonNull
    private String username;
    private Group group;

    public User(String username) {
        this.username = username;
    }
}
