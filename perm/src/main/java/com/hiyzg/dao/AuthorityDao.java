package com.hiyzg.dao;

import com.hiyzg.model.Authority;

import java.util.List;

/**
 * Created by Sam on 2019/9/30.
 */
public interface AuthorityDao extends BaseDao<Authority> {
    List<Authority> findByUserId(int userId);

    boolean deleteUserAuthorities(int id);

    boolean createUserAuthorities(int id, List<Integer> authorityIds);
}
