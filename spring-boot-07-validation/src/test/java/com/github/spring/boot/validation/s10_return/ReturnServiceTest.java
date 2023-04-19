package com.github.spring.boot.validation.s10_return;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

/**
 * create in 2022/8/6 18:13
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
class ReturnServiceTest {

    @Resource
    private ReturnService service;

    @Test
    void check1() {
        Assertions.assertThrowsExactly(ConstraintViolationException.class, () -> service.check(new UserCreateCommand()));
    }

    @Test
    void check2() {
        UserCreateCommand command = service.check(new UserCreateCommand("test_name"));
        Assertions.assertEquals("test_name", command.getUsername());
    }

}