package com.yangzg.lesson5;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

/**
 * Created by Sam on 2020/3/23.
 */
public class CalculatorFactoryBean implements FactoryBean<Calculator> {
    private String label;

    @Nullable
    @Override
    public Calculator getObject() throws Exception {
        System.out.println(String.format("calculator: %s", this.label));
        return new CalculatorImpl();
    }

    @Nullable
    @Override
    public Class<? extends Calculator> getObjectType() {
        return Calculator.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
