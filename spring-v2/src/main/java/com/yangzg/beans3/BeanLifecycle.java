package com.yangzg.beans3;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;

/**
 * Created by Sam on 2019/11/15.
 */
@Data
public class BeanLifecycle implements InitializingBean {
    private ApplicationContext applicationContext;

    public BeanLifecycle() {
        System.out.println("constructor");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
