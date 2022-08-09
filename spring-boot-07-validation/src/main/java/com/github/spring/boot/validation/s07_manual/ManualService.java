package com.github.spring.boot.validation.s07_manual;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * create in 2022/8/6 16:15
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Service
public class ManualService {

    public UserCreateCommand check(UserCreateCommand user) {
        log.info("{}", user);
        // 这两行可以提取为公共对象
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<UserCreateCommand>> set = validator.validate(user);
        for (ConstraintViolation<UserCreateCommand> constraintViolation : set) {
            System.out.println(constraintViolation.getMessage());
        }
        return user;
    }

}
