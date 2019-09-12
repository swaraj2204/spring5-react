package com.clari5.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomStringValidator implements ConstraintValidator<CustomStringContraints, String> {

    @Override
    public void initialize(CustomStringContraints constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !(value ==null || value.isEmpty());
    }
}
