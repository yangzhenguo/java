package com.yangzg.crud.validator;

import com.yangzg.crud.model.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Sam on 2019/11/28.
 */
public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.required");
        Person person = (Person)target;
        if (person.getAge() < 0 || person.getAge() > 120) {
            errors.rejectValue("age", "age.invalid");
        }
    }
}
