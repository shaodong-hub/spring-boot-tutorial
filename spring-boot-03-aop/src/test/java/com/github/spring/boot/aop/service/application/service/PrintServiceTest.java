package com.github.spring.boot.aop.service.application.service;

import com.github.spring.boot.aop.service.application.ArgsCommand;
import com.github.spring.boot.aop.service.application.DivCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * create in 2022/7/13 21:27
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
@DisplayName("测试除法")
class PrintServiceTest {

    @Resource
    private PrintService service;

    @Test
    void div() {
        Assertions.assertEquals(10, service.div1(new DivCommand(10)));
        Assertions.assertEquals(5, service.div2(new DivCommand(20)));
    }

    @Test
    void div3() {
        Assertions.assertEquals(10, service.div3(new ArgsCommand(10)));
        Assertions.assertEquals(5, service.div4(new ArgsCommand(20)));
    }


}