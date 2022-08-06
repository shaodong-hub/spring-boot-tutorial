package com.github.spring.boot.validation.s13_composition.annotation;

import com.github.spring.boot.validation.s13_composition.validator.PhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * create in 2021/5/14 3:40 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
//指定注解的处理类
@Constraint(validatedBy = {PhoneValidator.class})
public @interface Phone {

    String value() default "";

    String message() default "手机号码不符合规范";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
