package com.github.spring.boot.validation.s02_group;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;
import java.time.LocalDate;

/**
 * create in 2022/8/6 16:21
 *
 * @author shishaodong
 * @version 0.0.1
 */
@DisplayName("分组校验")
@SpringBootTest
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GroupValidateServiceTest {

    @Resource
    private GroupValidateService validateService;

    @Order(1)
    @DisplayName("对分组 1 进行校验")
    @Nested
    class Group1Check {

        @Order(1)
        @DisplayName("都满足条件时,不抛出异常")
        @ParameterizedTest
        @CsvSource({"test_username,spring-boot@qq.com,1"})
        void group11(String username, String email, long minus) {
            UserCreateCommand userCreateCommand = validateService.group1(new UserCreateCommand(username, email, LocalDate.now().minusDays(minus)));
            Assertions.assertEquals(username, userCreateCommand.getUsername());
        }

        @Order(2)
        @DisplayName("birthday 不满足条件时,抛出异常")
        @ParameterizedTest
        @CsvSource({"test_username,spring-boot@qq.com,1"})
        void group12(String username, String email, long minus) {
            UserCreateCommand userCreateCommand1 = new UserCreateCommand(username, email, LocalDate.now().plusDays(minus));
            Assertions.assertThrowsExactly(ConstraintViolationException.class, () -> validateService.group1(userCreateCommand1));
        }
    }

    @Order(2)
    @DisplayName("对分组 2 进行校验")
    @Nested
    class Group2Check {

        @Order(1)
        @DisplayName("都满足条件时,不抛出异常")
        @ParameterizedTest
        @CsvSource({"test_username,spring-boot@qq.com,1"})
        void group21(String username, String email, long minus) {
            UserCreateCommand userCreateCommand = validateService.group2(new UserCreateCommand(username, email, LocalDate.now().minusDays(minus)));
            Assertions.assertEquals(username, userCreateCommand.getUsername());
        }

        @Order(2)
        @DisplayName("birthday 是为未来的时间,也不抛出异常")
        @ParameterizedTest
        @CsvSource({"test_username,spring-boot@qq.com,1"})
        void group22(String username, String email, long minus) {
            UserCreateCommand userCreateCommand = validateService.group2(new UserCreateCommand(username, email, LocalDate.now().plusDays(minus)));
            Assertions.assertEquals(username, userCreateCommand.getUsername());
        }
    }
}