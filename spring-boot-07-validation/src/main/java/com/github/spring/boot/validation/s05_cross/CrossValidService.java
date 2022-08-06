package com.github.spring.boot.validation.s05_cross;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * create in 2022/8/6 16:15
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Service
@Validated
public class CrossValidService {

    @Cross
    public UserCreateCommand check(UserCreateCommand user1, UserCreateCommand user2) {
        log.info("{} - {}", user1, user2);
        return user1;
    }

}
