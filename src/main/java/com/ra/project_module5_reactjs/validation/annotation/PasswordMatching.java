package com.ra.project_module5_reactjs.validation.annotation;

import com.ra.project_module5_reactjs.validation.handle.PasswordMatchingValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PasswordMatchingValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordMatching {
    String password();
    String confirmPassword();
    String message() default "ConfirmPassword is not matching!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    @Target( ElementType.ANNOTATION_TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface List {
        PasswordMatching[] value();
    }
}
