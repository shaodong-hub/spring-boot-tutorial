package com.github.spring.boot.validation.s12_property;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * create in 2022/8/6 18:09
 *
 * @author shishaodong
 * @version 0.0.1
 */
@ActiveProfiles("junit")
@SpringBootTest
class ConfigValidatePropertyTest {

    @Resource
    private ConfigValidateProperty property;

    @Test
    void property(){

    }

}