package com.github.spring.boot.validation.s06_class;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;

/**
 * create in 2022/8/6 18:03
 *
 * @author shishaodong
 * @version 0.0.1
 */
@DisplayName("类级别校验")
@SpringBootTest
class ClassServiceTest {

    @Resource
    private ClassService classService;

    @ParameterizedTest
    @CsvSource("name,24,学士")
    void check1(String name, int age, String edu) {
        UserCreateCommand check = classService.check(new UserCreateCommand(name, age, edu));
        Assertions.assertEquals(name, check.getUsername());
    }

    @ParameterizedTest
    @CsvSource("name,27,学士")
    void check2(String name, int age, String edu) {
        Assertions.assertThrowsExactly(ConstraintViolationException.class,()-> classService.check(new UserCreateCommand(name, age, edu)));
    }

}