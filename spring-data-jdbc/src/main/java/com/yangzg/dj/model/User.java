package com.yangzg.dj.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;

/**
 * Created by Sam on 2019/12/12.
 */
@Data
@NoArgsConstructor
@AccessType(AccessType.Type.PROPERTY)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class User {
    @Id
    private String uid;
}
