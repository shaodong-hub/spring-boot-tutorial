package com.github.spring.boot.redis.domain.repository;

import jakarta.annotation.Resource;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

/**
 * create in 2023/3/30 10:21
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
@ActiveProfiles("junit")
class IHashRepositoryTest {


    @Resource
    IHashRepository repository;

    @Test
    void add() {
        List<String> list = Lists.list("1", "2", "3", "1", "1");
        list.forEach(s -> System.out.println(repository.add(s)));
    }
}