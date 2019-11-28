package com.hiyzg.shop.util;

import org.junit.Test;

import javax.sql.DataSource;

import static org.junit.Assert.*;

/**
 * Created by Sam on 2019/10/11.
 */
public class DataSourceUtilTest {
    @Test
    public void getDataSource() throws Exception {
        final DataSource dataSource = DataSourceUtil.getDataSource();
        assertNotNull(dataSource);
    }

}