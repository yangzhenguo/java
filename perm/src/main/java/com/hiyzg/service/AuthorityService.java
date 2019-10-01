package com.hiyzg.service;

import com.hiyzg.model.Authority;

import java.util.Optional;

/**
 * Created by Sam on 2019/10/1.
 */
public interface AuthorityService {
    Optional<Authority> get(int id);
}
