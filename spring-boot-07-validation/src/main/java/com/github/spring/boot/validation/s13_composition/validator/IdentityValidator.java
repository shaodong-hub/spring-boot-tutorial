package com.github.spring.boot.validation.s13_composition.validator;

import com.github.spring.boot.validation.s13_composition.annotation.Identity;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * create in 2021/5/14 3:43 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
public class IdentityValidator implements ConstraintValidator<Identity, String> {

    private String pattern = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([\\d|x|X]{1})$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Pattern.matches(pattern, value);
    }
}
