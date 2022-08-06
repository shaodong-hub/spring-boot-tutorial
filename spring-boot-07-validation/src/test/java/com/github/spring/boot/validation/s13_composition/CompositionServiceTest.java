package com.github.spring.boot.validation.s13_composition;

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

/**
 * create in 2022/8/6 17:08
 *
 * @author shishaodong
 * @version 0.0.1
 */
@DisplayName("组合校验")
@SpringBootTest
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CompositionServiceTest {

    @Resource
    private CompositionService compositionService;

    @DisplayName("测试 身份证号码/护照号/手机号")
    @Nested
    class CompositionCheck {

        @Order(1)
        @DisplayName("测试 手机号")
        @ParameterizedTest
        @CsvSource({"18888888888"})
        void mobile(String mobile) {
            UserCreateCommand composition = compositionService.composition(new UserCreateCommand(mobile));
            Assertions.assertEquals(mobile, composition.getIdentity());
        }

        @Order(2)
        @DisplayName("测试 护照号")
        @ParameterizedTest
        @CsvSource({"H123456"})
        void passport(String passport) {
            UserCreateCommand composition = compositionService.composition(new UserCreateCommand(passport));
            Assertions.assertEquals(passport, composition.getIdentity());
        }

        @Order(3)
        @DisplayName("测试 身份证号码")
        @ParameterizedTest
        @CsvSource({"320830202201010505"})
        void identity(String identity) {
            UserCreateCommand composition = compositionService.composition(new UserCreateCommand(identity));
            Assertions.assertEquals(identity, composition.getIdentity());
        }

        @Order(4)
        @DisplayName("测试 异常用例")
        @ParameterizedTest
        @CsvSource({"123"})
        void invalidInput(String invalidInput) {
            Assertions.assertThrowsExactly(ConstraintViolationException.class, () -> compositionService.composition(new UserCreateCommand(invalidInput)));
        }
    }
}