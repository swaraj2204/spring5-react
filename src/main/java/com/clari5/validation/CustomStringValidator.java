package com.clari5.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomStringValidator implements ConstraintValidator<CustomStringConstraints, String> {

    @Override
    public void initialize(CustomStringConstraints constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !(value ==null || value.isEmpty());
    }
}
