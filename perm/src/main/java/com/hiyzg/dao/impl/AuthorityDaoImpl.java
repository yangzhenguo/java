package com.hiyzg.dao.impl;

import com.hiyzg.dao.AuthorityDao;
import com.hiyzg.model.Authority;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    @Override
    public boolean deleteUserAuthorities(int id) {
        try {
            return this.queryRunner.update("delete from user_authority where user_id = ?", id) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean createUserAuthorities(int id, List<Integer> authorityIds) {
        final Object[][] params = new Object[authorityIds.size()][2];
        for (int i = 0; i < authorityIds.size(); i++) {
            params[i][0] = id;
            params[i][1] = authorityIds.get(i);
        }
        try {
            final List<Map<String, Object>> results = this.queryRunner.insertBatch("insert into user_authority(user_id, authority_id) values(?, ?)", new MapListHandler(), params);
            return results.size() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
