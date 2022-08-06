package com.github.spring.boot.validation.s01_bastic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;
import java.time.LocalDate;

/**
 * create in 2022/8/6 16:16
 *
 * @author shishaodong
 * @version 0.0.1
 */
@DisplayName("基础用法")
@SpringBootTest
class BasicServiceTest {

    @Resource
    private BasicService infoService;

    @Nested
    class Check {

        @ParameterizedTest
        @DisplayName("当条件都满足时,不抛出异常")
        @CsvSource({"test_username,18,spring-boot@qq.com,1"})
        void check1(String username, int age, String email, long minus) {
            UserCreateCommand check = infoService.check(new UserCreateCommand(username, age, email, LocalDate.now().minusDays(minus)));
            Assertions.assertEquals("test_username", check.getUsername());
        }

        @ParameterizedTest
        @DisplayName("当生日输入的时间为未来的时间时,则抛出 ConstraintViolationException 异常")
        @CsvSource({"test_username,18,spring-boot@qq.com,1"})
        void check2(String username, int age, String email, long minus) {
            Assertions.assertThrowsExactly(ConstraintViolationException.class, () -> infoService.check(new UserCreateCommand(username, age, email, LocalDate.now().plusDays(minus))));
        }
    }

}