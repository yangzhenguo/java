package com.hiyzg.dao.impl;

import com.hiyzg.dao.AuthorityDao;
import com.hiyzg.model.Authority;
import org.junit.Test;

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

}