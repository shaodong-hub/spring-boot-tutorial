package com.github.spring.boot.validation.s15_script;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * create in 2022/8/7 00:04
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
class ScriptServiceTest {

    @Resource
    private ScriptService service;

    @Test
    void check() {
        service.check(Collections.singletonList(""), Collections.emptyList());
    }
}