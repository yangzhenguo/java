package com.yangzg.dj.service;

import com.yangzg.dj.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Sam on 2019/12/13.
 */
public interface UserService {
    Page<User> findAll(Pageable pageable);
}
