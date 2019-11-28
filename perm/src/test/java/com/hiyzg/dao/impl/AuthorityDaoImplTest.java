package com.hiyzg.dao.impl;

import com.hiyzg.dao.AuthorityDao;
import com.hiyzg.model.Authority;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Sam on 2019/10/1.
 */
public class AuthorityDaoImplTest {
    private AuthorityDao authorityDao = new AuthorityDaoImpl();

    @Test
    public void findByUserId() throws Exception {
        final List<Authority> authorities = this.authorityDao.findByUserId(1);
        System.out.println(authorities);
        assertTrue(authorities.size() > 0);
    }

    @Test
    public void createUserAuthorities() {
        final boolean success = this.authorityDao.createUserAuthorities(2, Arrays.asList(1, 2));
        System.out.println(success);
        assertTrue(success);
    }

    @Test
    public void deleteUserAuthorities() {
        final boolean success = this.authorityDao.deleteUserAuthorities(2);
        assertTrue(success);
    }
}