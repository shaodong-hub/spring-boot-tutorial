package com.github.spring.boot.validation.s14_fast;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;
import java.time.LocalDate;


/**
 * create in 2022/8/6 17:20
 *
 * @author shishaodong
 * @version 0.0.1
 */
@ActiveProfiles("junit")
@DisplayName("快速失败用法")
@SpringBootTest
class FailFastServiceTest {

    @Resource
    private FailFastService infoService;

    @Nested
    class Check {

        @ParameterizedTest
        @DisplayName("有一个输入不合规即返回")
        @CsvSource({"test,25,spring-boot,1"})
        void check2(String username, int age, String email, long minus) {
            infoService.check(new UserCreateCommand(username, age, email, LocalDate.now().plusDays(minus)));
            Assertions.assertThrowsExactly(ConstraintViolationException.class, () -> infoService.check(new UserCreateCommand(username, age, email, LocalDate.now().plusDays(minus))));
        }
    }

}