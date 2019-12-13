package com.yangzg.dj.repository;

import com.yangzg.dj.BaseTest;
import com.yangzg.dj.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Created by Sam on 2019/12/13.
 */
public class UserRepositoryTest extends BaseTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void selectOne() throws Exception {
        System.out.println(this.userRepository.selectOne());
    }

    @Test
    public void findById() throws Exception {
        System.out.println(this.userRepository.findById("62145f6e66ea4f5cbe7b6f6b954917d3"));
    }

    @Test
    public void findAllByUidBefore() throws Exception {
        final Page<User> page = this.userRepository.findAllByUidBefore("z", PageRequest.of(1, 10));
        page.forEach(System.out::println);
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
    }
}