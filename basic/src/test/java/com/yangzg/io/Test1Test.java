package com.yangzg.io;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Sam on 2019/9/17.
 */
public class Test1Test {
    @Test
    public void test1() throws IOException {
        FileUtils.copyURLToFile(new URL("http://www.baidu.com"), new File("haha.txt"));
    }
}