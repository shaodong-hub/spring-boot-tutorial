package com.github.spring.boot.validation.s05_cross;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * 创建时间为 下午2:19-2019/1/24
 * 项目名称 SpringBootValidated
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */


@Constraint(validatedBy = CrossValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@Documented
public @interface Cross {

    String message() default "{password.confirmation.error}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
