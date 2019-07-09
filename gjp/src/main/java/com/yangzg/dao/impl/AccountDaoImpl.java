package com.yangzg.dao.impl;

import com.yangzg.dao.inf.AccountDao;
import com.yangzg.model.Account;
import com.yangzg.util.JDBCUtil;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/7/9.
 */
public class AccountDaoImpl implements AccountDao {
    public static final Logger LOGGER = LoggerFactory.getLogger(AccountDaoImpl.class);
    private QueryRunner queryRunner = JDBCUtil.getQueryRunner();

    private static final RowProcessor ROW_PROCESSOR = new BasicRowProcessor(new BeanProcessor(new HashMap<String, String>() {
        private static final long serialVersionUID = 7302016124521919954L;

        {
            put("zwid", "id");
            put("flname", "category");
            put("money", "price");
            put("zhanghu", "name");
            put("createtime", "createDate");
        }
    }));

    @Override
    public List<Account> selectAll() {
        try {
            return this.queryRunner.query("select * from gjp_zhangwu", new BeanListHandler<Account>(Account.class, ROW_PROCESSOR));
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error(e.toString());
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public Optional<Account> selectById(Integer id) {
        try {
            return Optional.ofNullable(this.queryRunner.query("select * from gjp_zhangwu where zwid = ?", new BeanHandler<Account>(Account.class, ROW_PROCESSOR), id));
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error(e.toString());
            return Optional.empty();
        }
    }

    @Override
    public boolean update(Account bean) {
        try {
            return this.queryRunner.update("update gjp_zhangwu set flname = ?, zhanghu = ?, money = ? where zwid = ?", bean.getCategory(), bean.getName(), bean.getPrice(), bean.getId()) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error(e.toString());
            return false;
        }
    }
}
