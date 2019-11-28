package com.hiyzg.service.impl;

import com.hiyzg.dao.AuthorityDao;
import com.hiyzg.dao.UserDao;
import com.hiyzg.dao.impl.AuthorityDaoImpl;
import com.hiyzg.dao.impl.UserDaoImpl;
import com.hiyzg.model.Authority;
import com.hiyzg.service.AuthorityService;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/10/1.
 */
public class AuthorityServiceImpl implements AuthorityService {
    private UserDao userDao = new UserDaoImpl();
    private AuthorityDao authorityDao = new AuthorityDaoImpl();

    @Override
    public Optional<Authority> get(int id) {
        final Optional<Authority> authorityOptional = this.authorityDao.findById(id);
        authorityOptional.ifPresent(authority -> authority.setUsers(this.userDao.findByAuthorityId(authority.getId())));
        return authorityOptional;
    }

    @Override
    public List<Authority> getAll() {
        return this.authorityDao.findAll();
    }

    @Override
    public boolean updateAuthorities(int id, List<Integer> AuthorityIds) {
        return this.authorityDao.deleteUserAuthorities(id) & this.authorityDao.createUserAuthorities(id, AuthorityIds);
    }
}
