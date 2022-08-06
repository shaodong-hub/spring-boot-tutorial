package com.github.spring.boot.validation.s13_composition.validator;

import com.github.spring.boot.validation.s13_composition.annotation.Phone;
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
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private String pattern = "^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Pattern.matches(pattern, value);
    }
}
