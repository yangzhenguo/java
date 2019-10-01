package com.hiyzg.service.impl;

import com.hiyzg.model.Authority;
import com.hiyzg.service.AuthorityService;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by Sam on 2019/10/1.
 */
public class AuthorityServiceImplTest {
    private AuthorityService authorityService = new AuthorityServiceImpl();

    @Test
    public void get() throws Exception {
        final Optional<Authority> authorityOptional = this.authorityService.get(1);
        authorityOptional.ifPresent(System.out::println);
        assertTrue(authorityOptional.isPresent());
    }

}