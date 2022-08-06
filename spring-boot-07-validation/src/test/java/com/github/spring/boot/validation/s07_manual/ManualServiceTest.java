package com.github.spring.boot.validation.s07_manual;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDate;

/**
 * create in 2022/8/6 18:19
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
class ManualServiceTest {

    @Resource
    private ManualService service;

    @Test
    void check() {
        UserCreateCommand check = service.check(new UserCreateCommand("username", 111, "email", LocalDate.now().plusDays(1)));
        Assertions.assertEquals("username", check.getUsername());
    }
}