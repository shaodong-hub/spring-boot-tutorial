package com.github.spring.boot.aop.application.service;

import com.github.spring.boot.aop.application.ArgsCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * create in 2022/7/29 00:21
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
@DisplayName("测试失效场景")
class PrintNotWorkServiceTest {

    @Resource
    private PrintNotWorkService service;

    @Test
    @DisplayName("同一个类中调用失效")
    void div5NotWork() {
        Assertions.assertEquals(5, service.div5NotWork(new ArgsCommand(20)));
    }
}