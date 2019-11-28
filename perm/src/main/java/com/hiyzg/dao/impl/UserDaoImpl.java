package com.hiyzg.dao.impl;

import com.hiyzg.dao.UserDao;
import com.hiyzg.model.User;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/9/30.
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    @Override
    public Optional<User> findByUsername(String username) {
        try {
            return Optional.ofNullable(this.queryRunner.query(String.format("select * from %s where username = ?", this.getTableName()), new BeanHandler<User>(User.class), username));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<User> findByAuthorityId(Integer authorityId) {
        final String tableName = this.getTableName();
        String sql = String.format("select %s.* from %s left join user_authority on (%s.id = user_authority.authority_id) where user_authority.user_id = ?", tableName, tableName, tableName);
        try {
            return this.queryRunner.query(sql, new BeanListHandler<User>(this.getClazz()), authorityId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
