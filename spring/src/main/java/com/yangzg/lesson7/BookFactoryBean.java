package com.yangzg.lesson7;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

/**
 * @author Sam
 * @date 2020/3/29 8:09 PM
 */
public class BookFactoryBean implements FactoryBean<Book> {
    @Nullable
    @Override
    public Book getObject() throws Exception {
        System.out.println("----->: book");
        return new Book();
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
