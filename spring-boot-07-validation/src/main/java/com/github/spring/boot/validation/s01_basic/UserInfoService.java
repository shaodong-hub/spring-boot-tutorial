package com.github.spring.boot.validation.s01_basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * create in 2023/1/2 23:15
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Service
@Validated
public class UserInfoService {

    public UserCreateCommand check(@Valid UserCreateCommand command) {
        return command;
    }

    public UserCreateCommand check(@Valid UserCreateCommand command1, UserCreateCommand command2) {
        return command1;
    }
}
