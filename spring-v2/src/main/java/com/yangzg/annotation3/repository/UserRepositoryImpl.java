package com.yangzg.annotation3.repository;

import org.springframework.stereotype.Service;

/**
 * Created by Sam on 2019/11/18.
 */
@Service
public class UserRepositoryImpl implements UserRepository {
    @Override
    public void say() {
        System.out.println("UserRepository save.");
    }
}
