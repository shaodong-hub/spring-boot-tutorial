package com.github.spring.boot.validation.s02_group;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * create in 2021/5/13 11:27 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Validated
@Service
public class GroupValidateService {

    @Validated(Group1.class)
    public UserCreateCommand group1(@Valid UserCreateCommand data) {
        return data;
    }

    @Validated(Group2.class)
    public UserCreateCommand group2(@Valid UserCreateCommand data) {
        return data;
    }


}
