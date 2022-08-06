package com.github.spring.boot.validation.s11_sequence.annotation;

import com.github.spring.boot.validation.s05_cross.CrossValidator;
import com.github.spring.boot.validation.s11_sequence.validator.CustomOrder1Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * create in 2022/8/6 18:28
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Constraint(validatedBy = CustomOrder1Validator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface CustomOrder1 {

    String value() default "";

    String message() default "CustomOrder1";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
