package com.yangzg.thread.service.impl;

import com.yangzg.thread.service.SenderService;

/**
 * Created by Sam on 2020/2/21.
 */
public class SmsSenderService extends SenderService {
    @Override
    public void send() {
        System.out.println("send sms");
    }
}
