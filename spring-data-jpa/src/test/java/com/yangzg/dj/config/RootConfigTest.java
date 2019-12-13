package com.yangzg.dj.config;

import com.yangzg.dj.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

import static org.junit.Assert.*;

/**
 * Created by Sam on 2019/12/13.
 */
public class RootConfigTest extends BaseTest {
    @Autowired
    private DataSource dataSource;

    @Test
    public void dataSource() throws Exception {
        assertNotNull(this.dataSource);
    }

}