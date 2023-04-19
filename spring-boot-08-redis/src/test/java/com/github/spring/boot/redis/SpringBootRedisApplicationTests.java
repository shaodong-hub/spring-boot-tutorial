package com.github.spring.boot.redis;

import jakarta.annotation.Resource;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("junit")
class SpringBootRedisApplicationTests {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @RepeatedTest(10)
    void opsForSetAdd() {
        stringRedisTemplate.opsForSet().add("111", RandomStringUtils.randomAlphabetic(10));
    }

    @Test
    void contextLoads() {
    }

}
