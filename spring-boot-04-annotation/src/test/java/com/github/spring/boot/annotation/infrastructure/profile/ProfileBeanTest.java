package com.github.spring.boot.annotation.infrastructure.profile;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

/**
 * create in 2022/7/13 23:11
 *
 * @author shishaodong
 * @version 0.0.1
 */
@ActiveProfiles("redis")
@SpringBootTest
class ProfileBeanTest {

    @Resource
    private ApplicationContext context;

    @Test
    void profile() {
        Assertions.assertNotNull(context.getBean(ProfileBean.class));
    }

}