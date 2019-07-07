package com.yangzg.chapter11;

import org.junit.Test;

import java.util.List;

/**
 * Created by Sam on 2019/7/7.
 */
public class JDBCUtilTest {
    @Test
    public void queryList1() throws Exception {
        List<User> users = JDBCUtil.queryList("select * from users limit ?, ?", User.class, new Object[]{0, 1});
        System.out.println(users);
    }

    @Test
    public void queryList2() throws Exception {
        List<Account> users = JDBCUtil.queryList("select * from account", Account.class);
        System.out.println(users);
    }
}