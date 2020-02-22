package com.yangzg.factory.test001.model;

import lombok.Data;

/**
 * Created by Sam on 2020/2/21.
 * @author Sam
 */
@Data
public abstract class Pizza {
    protected String name;

    public String getName() {
        return name;
    }
}
