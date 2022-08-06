package com.github.spring.boot.validation.s04_custom;

import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * <p>
 * 创建时间为 下午6:20 2019/9/27
 * 项目名称 spring-boot-validated
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public class UsernameValidator implements ConstraintValidator<Username, String> {

    @Resource
    private UserInfoRepository repository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.startsWithIgnoreCase(value, "test_") && repository.existByUsername(value);
    }

}
