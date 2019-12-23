package com.yangzg.dr.service;

/**
 * Created by Sam on 2019/12/18.
 */
public interface ActivityService {
    void execute(String key, String message);

    boolean using();
}
