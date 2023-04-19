package com.github.spring.boot.validation.s05_cross;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * create in 2022/8/6 17:47
 *
 * @author shishaodong
 * @version 0.0.1
 */
@DisplayName("参数交叉验证")
@SpringBootTest
class CrossValidServiceTest {

    @Resource
    private CrossValidService service;

    @Test
    void check() {
        UserCreateCommand check = service.check(new UserCreateCommand("test_username"), new UserCreateCommand("test_username"));
        Assertions.assertEquals("test_username", check.getUsername());
    }
}