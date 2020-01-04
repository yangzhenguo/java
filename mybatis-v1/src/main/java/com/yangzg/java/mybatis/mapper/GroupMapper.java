package com.yangzg.java.mybatis.mapper;

import com.yangzg.java.mybatis.model.Group;

import java.util.Optional;

/**
 * Created by Sam on 2020/1/1.
 * @author Sam
 */
public interface GroupMapper {
    /**
     * selectGroup
     * @param id
     * @return
     */
    Optional<Group> selectGroupById(final int id);
}
