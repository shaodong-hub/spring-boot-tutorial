package com.github.spring.boot.validation.s11_sequence.annotation;

import com.github.spring.boot.validation.s11_sequence.validator.CustomOrder3Validator;

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
@Constraint(validatedBy = CustomOrder3Validator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@Documented
public @interface CustomOrder3 {

    String message() default "CustomOrder2";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
