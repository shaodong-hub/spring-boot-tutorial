package com.github.spring.boot.validation.s10_return;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * create in 2022/8/6 16:15
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Service
@Validated
public class ReturnService {


    public @NotNull UserCreateCommand check(UserCreateCommand user) {
        log.info("{}", user);
        if (StringUtils.isBlank(user.getUsername())) {
            return null;
        }
        return user;
    }

}
