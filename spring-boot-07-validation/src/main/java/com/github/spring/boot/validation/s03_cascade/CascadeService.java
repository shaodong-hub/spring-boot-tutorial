package com.github.spring.boot.validation.s03_cascade;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * create in 2021/5/14 9:27 上午
 * Validated JSR349
 * Valid     JSR303
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Validated
@Service
public class CascadeService {

    public UserInfoCommand cascade(@Valid UserInfoCommand userInfo) {
        return userInfo;
    }

}
