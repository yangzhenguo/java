package com.yangzg.thread.provider;

import com.yangzg.thread.provider.impl.EmailProvider;
import org.junit.Test;

/**
 * Created by Sam on 2020/2/21.
 */
public class AbstractProviderTest {
    @Test
    public void test1() throws Exception {
        new EmailProvider().provide().send();
    }
}