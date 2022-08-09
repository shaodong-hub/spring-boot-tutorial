package com.github.spring.boot.validation.s04_custom;


import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * create in 2021/5/14 10:07 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
//指定注解的处理类
@Constraint(validatedBy = {UsernameValidator.class})
@ReportAsSingleViolation
public @interface Username {

    String value() default "";

    String message() default "用户 ID 不存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
