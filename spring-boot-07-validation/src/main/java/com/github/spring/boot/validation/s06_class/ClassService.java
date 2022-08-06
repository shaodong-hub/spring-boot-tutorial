package com.github.spring.boot.validation.s06_class;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * create in 2022/8/6 16:15
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Service
@Validated
public class ClassService {

    public UserCreateCommand check(@Valid UserCreateCommand user) {
        log.info("{}", user);
        return user;
    }

}
