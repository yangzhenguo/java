package com.hiyzg.shop.util;

import org.junit.Test;

import java.text.MessageFormat;

/**
 * Created by Sam on 2019/10/16.
 */
public class MessageFormatTest {
    @Test
    public void test1() {
        final MessageFormat messageFormat = new MessageFormat("You don''t have any products yet, and{0}.");
//        messageFormat.applyPattern("sldkfj{0}");
        System.out.println(messageFormat.format(new String[]{"abc"}));
    }
}
