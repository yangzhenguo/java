package com.yangzg.thread.provider.impl;

import com.yangzg.thread.provider.AbstractProvider;
import com.yangzg.thread.service.SenderService;
import com.yangzg.thread.service.impl.EmailSenderService;

/**
 * Created by Sam on 2020/2/21.
 */
public class EmailProvider extends AbstractProvider {
    @Override
    public SenderService provide() {
        return new EmailSenderService();
    }
}
