package com.github.spring.boot.validation.s13_composition.annotation;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 组合注解, 把需要校验的规则统统放到这个注解上面
 * 如 {@link Identity} {@link Passport} {@link Phone},
 * <p>
 * <p>
 * create in 2021/5/14 3:36 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Identity
@Passport
@Phone
@ConstraintComposition(CompositionType.OR)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Constraint(validatedBy = {})
@ReportAsSingleViolation
public @interface Composition {

    String message() default "请输入正确的身份证号码/护照号/手机号";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
