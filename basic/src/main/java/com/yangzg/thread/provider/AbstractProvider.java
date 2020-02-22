package com.yangzg.thread.provider;

import com.yangzg.thread.service.SenderService;

/**
 * Created by Sam on 2020/2/21.
 */
public abstract class AbstractProvider {
    public abstract SenderService provide();
}
