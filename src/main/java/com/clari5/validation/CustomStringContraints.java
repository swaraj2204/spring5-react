package com.clari5.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CustomStringValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomStringContraints {

    String message() default "Invalid String";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
