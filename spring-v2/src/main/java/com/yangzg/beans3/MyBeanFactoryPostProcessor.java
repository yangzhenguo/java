package com.yangzg.beans3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;

/**
 * Created by Sam on 2019/11/16.
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor, Ordered {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println(String.join("\n", configurableListableBeanFactory.getBeanDefinitionNames()));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
