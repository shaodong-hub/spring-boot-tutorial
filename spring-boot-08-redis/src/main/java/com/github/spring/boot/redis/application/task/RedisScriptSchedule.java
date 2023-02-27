package com.github.spring.boot.redis.application.task;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * create in 2023/1/31 14:53
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class RedisScriptSchedule {

    private final StringRedisTemplate stringRedisTemplate;

    private final RedisScript<Long> finiteTimeSet;

    @Scheduled(fixedRate = 1000L)
    public void task() {
        String key = "S123456";
        Long execute = stringRedisTemplate.execute(finiteTimeSet, Collections.singletonList(key), RandomStringUtils.randomAlphabetic(10), "3000");
        log.error("execute - {}", execute);
    }
}
