package com.github.spring.boot.validation.s11_sequence.validator;

import com.github.spring.boot.validation.s11_sequence.annotation.CustomOrder3;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * create in 2022/8/6 18:29
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
public class CustomOrder3Validator implements ConstraintValidator<CustomOrder3, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("CustomOrder3Validator");
        return true;
    }
}
