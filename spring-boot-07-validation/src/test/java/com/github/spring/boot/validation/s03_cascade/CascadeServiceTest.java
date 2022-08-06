package com.github.spring.boot.validation.s03_cascade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * create in 2022/8/6 16:52
 *
 * @author shishaodong
 * @version 0.0.1
 */
@DisplayName("级联校验")
@SpringBootTest
class CascadeServiceTest {

    @Resource
    private CascadeService cascadeService;

    @Test
    void cascade() {

    }
}