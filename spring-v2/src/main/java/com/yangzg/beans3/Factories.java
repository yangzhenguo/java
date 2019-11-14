package com.yangzg.beans3;

import lombok.Data;

import java.util.Map;

/**
 * Created by Sam on 2019/11/14.
 */
@Data
public abstract class Factories {
    private Map<String, Object> objects;
    public abstract User getUser();
}
