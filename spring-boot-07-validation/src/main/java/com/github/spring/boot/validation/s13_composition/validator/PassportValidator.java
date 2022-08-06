package com.github.spring.boot.validation.s13_composition.validator;

import com.github.spring.boot.validation.s13_composition.annotation.Passport;
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
public class PassportValidator implements ConstraintValidator<Passport, String> {

    /**
     * "H123456"
     */
    private String pattern = "^([A-Z]\\d{6,10}(\\(\\w{1}\\))?)$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Pattern.matches(pattern, value);
    }
}
