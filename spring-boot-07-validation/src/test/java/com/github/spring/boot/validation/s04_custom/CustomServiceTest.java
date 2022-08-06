package com.github.spring.boot.validation.s04_custom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;

/**
 * create in 2022/8/6 16:56
 *
 * @author shishaodong
 * @version 0.0.1
 */
@DisplayName("自定义校验")
@SpringBootTest
class CustomServiceTest {

    @Resource
    private CustomService customService;

    @Nested
    class Custom {

        @ParameterizedTest
        @CsvSource({"test_username"})
        void custom1(String username) {
            UserCreateCommand custom = customService.custom(new UserCreateCommand(username));
            Assertions.assertEquals(username, custom.getUsername());
        }

        @ParameterizedTest
        @CsvSource({"username"})
        void custom2(String username) {
            Assertions.assertThrowsExactly(ConstraintViolationException.class, () -> customService.custom(new UserCreateCommand(username)));
        }
    }
}