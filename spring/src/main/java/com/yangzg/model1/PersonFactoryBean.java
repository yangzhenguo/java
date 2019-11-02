package com.yangzg.model1;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by Sam on 2019/10/30.
 */
@Data
public class PersonFactoryBean implements FactoryBean<Person> {
    private String name;
    private int age;
    private Car car;

    @Override
    public Person getObject() throws Exception {
        return new Person(this.getName(), this.age, this.car);
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
