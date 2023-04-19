package com.github.spring.boot.annotation.infrastructure.bean;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * create in 2022/7/13 23:15
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
class UserInfoTest {

    @Resource
    private ApplicationContext context;

    @Resource
    private UserInfo userInfo;

    @Test
    @DisplayName("获取优选 bean")
    void primary() {
        Assertions.assertEquals("test name 1", userInfo.getName());
    }

    @Test
    @DisplayName("获取所有的 bean")
    void beans() {
        Map<String, UserInfo> beansOfType = context.getBeansOfType(UserInfo.class);
        Assertions.assertEquals(2, beansOfType.size());
    }

}