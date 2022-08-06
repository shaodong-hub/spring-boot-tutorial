package com.github.spring.boot.validation.s09_message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * create in 2021/5/14 3:15 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Validated
@Service
public class MessageService {

    public UserCreateCommand message(@Valid UserCreateCommand user) {
        return user;
    }

}
