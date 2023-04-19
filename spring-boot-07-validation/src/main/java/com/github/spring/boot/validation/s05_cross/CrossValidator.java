package com.github.spring.boot.validation.s05_cross;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

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
@Slf4j
@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class CrossValidator implements ConstraintValidator<Cross, Object[]> {

    @Resource
    private ObjectMapper objectMapper;

    @Override
    @SneakyThrows(JsonProcessingException.class)
    public boolean isValid(Object[] values, ConstraintValidatorContext context) {
        String data1 = objectMapper.writeValueAsString(values[0]);
        String data2 = objectMapper.writeValueAsString(values[1]);
        log.info("data1-{}    data2-{}", data1, data2);
        return StringUtils.equalsIgnoreCase(data1, data2);
    }
}
