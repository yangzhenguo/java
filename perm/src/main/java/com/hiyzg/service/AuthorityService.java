package com.hiyzg.service;

import com.hiyzg.model.Authority;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/10/1.
 */
public interface AuthorityService {
    Optional<Authority> get(int id);

    List<Authority> getAll();

    boolean updateAuthorities(int id, List<Integer> collect);
}
