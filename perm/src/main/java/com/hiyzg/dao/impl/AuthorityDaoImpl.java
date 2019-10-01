package com.hiyzg.dao.impl;

import com.hiyzg.dao.AuthorityDao;
import com.hiyzg.model.Authority;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sam on 2019/9/30.
 */
public class AuthorityDaoImpl extends BaseDaoImpl<Authority> implements AuthorityDao {
    @Override
    public List<Authority> findByUserId(int userId) {
        final String tableName = this.getTableName();
        String sql = String.format("select %s.* from %s left join user_authority on (%s.id = user_authority.authority_id) where user_authority.user_id = ?", tableName, tableName, tableName);
        try {
            return this.queryRunner.query(sql, new BeanListHandler<Authority>(this.getClazz()), userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
