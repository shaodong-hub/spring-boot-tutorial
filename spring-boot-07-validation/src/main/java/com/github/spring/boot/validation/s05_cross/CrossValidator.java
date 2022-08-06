package com.github.spring.boot.validation.s05_cross;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

/**
 * <p>
 * 创建时间为 13:14 2019-04-17
 * 项目名称 spring-boot-validated
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class CrossValidator implements ConstraintValidator<Cross, Object[]> {

    @Resource
    private ObjectMapper objectMapper;

    @Override
    @SneakyThrows(JsonProcessingException.class)
    public boolean isValid(Object[] values, ConstraintValidatorContext context) {
        return StringUtils.equalsIgnoreCase(objectMapper.writeValueAsString(values[0]), objectMapper.writeValueAsString(values[1]));
    }

}
