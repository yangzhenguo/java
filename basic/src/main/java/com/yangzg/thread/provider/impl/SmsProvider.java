package com.yangzg.thread.provider.impl;

import com.yangzg.thread.provider.AbstractProvider;
import com.yangzg.thread.service.SenderService;
import com.yangzg.thread.service.impl.SmsSenderService;

/**
 * Created by Sam on 2020/2/21.
 */
public class SmsProvider extends AbstractProvider {
    @Override
    public SenderService provide() {
        return new SmsSenderService();
    }
}
