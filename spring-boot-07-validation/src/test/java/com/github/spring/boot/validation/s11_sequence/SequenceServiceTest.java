package com.github.spring.boot.validation.s11_sequence;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * create in 2022/8/6 18:34
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
class SequenceServiceTest {

    @Resource
    private SequenceService service;

    @Test
    void check() {
        UserCreateCommand command = service.check(new UserCreateCommand("test_name"));
        Assertions.assertEquals("test_name", command.getUsername());

    }
}