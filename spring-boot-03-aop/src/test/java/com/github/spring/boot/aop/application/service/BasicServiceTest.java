package com.github.spring.boot.aop.application.service;

import com.github.spring.boot.aop.application.DivCommand;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * create in 2022/7/13 21:07
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
@DisplayName("测试除法")
class BasicServiceTest {

    @Resource
    private DivService service;

    @ParameterizedTest
    @DisplayName("正常用例")
    @CsvSource({"10,10", "25,4", "20,5"})
    void div(int target, int expect) {
        Assertions.assertEquals(expect, service.div(new DivCommand(target)));
    }

    @Test
    void div() {
        Assertions.assertThrows(Exception.class, () -> service.div(new DivCommand(0)));
    }

}