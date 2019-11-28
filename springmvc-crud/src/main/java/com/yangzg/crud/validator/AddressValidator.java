package com.yangzg.crud.validator;

import com.yangzg.crud.model.Address;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Sam on 2019/11/28.
 */
public class AddressValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Address.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "province", "province.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "city.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "area", "area.required");
        Address address = (Address) target;
        if (address.getProvince().length() > 100) errors.rejectValue("province", "province.length");
        if (address.getCity().length() > 100) errors.rejectValue("city", "city.length");
        if (address.getArea().length() > 100) errors.rejectValue("area", "area.length");
    }

    public static void main(String[] args) {
        final BeanWrapper beanWrapper = new BeanWrapperImpl(new Address());
        beanWrapper.setPropertyValue("province", "ShanXi");
    }
}
