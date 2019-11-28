package com.yangzg.crud.validator;

import com.yangzg.crud.model.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Sam on 2019/11/28.
 */
public class CustomerValidator implements Validator {
    private final AddressValidator addressValidator;

    public CustomerValidator(AddressValidator addressValidator) {
        if (null == addressValidator) {
            throw new IllegalArgumentException();
        }
        this.addressValidator = addressValidator;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName,required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName,required");
        final Customer customer = (Customer) target;
        try {
            errors.pushNestedPath("address");
            ValidationUtils.invokeValidator(this.addressValidator, customer.getAddress(), errors);
        } finally {
            errors.popNestedPath();
        }
    }
}
