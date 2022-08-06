package com.github.spring.boot.validation.s13_composition.annotation;

import com.github.spring.boot.validation.s13_composition.validator.IdentityValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * create in 2021/5/14 3:39 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
//指定注解的处理类
@Constraint(validatedBy = {IdentityValidator.class})
public @interface Identity {


    String value() default "";

    String message() default "用户身份证号码不符合规范";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
