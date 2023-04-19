package com.github.mongo.domain.repository;

import com.github.mongo.domain.entity.AutoCreateEntity;
import jakarta.annotation.Resource;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.time.LocalDateTime;
import java.util.List;


/**
 * create in 2023/3/28 15:07
 *
 * @author shishaodong
 * @version 0.0.1
 */
@DataMongoTest
class IAutoCreateRepositoryTest {

    @Resource
    IAutoCreateRepository repository;

    List<AutoCreateEntity> list = Lists.list();

    int count = 10;

    @BeforeEach
    void before() {
        for (int i = 0; i < count; i++) {
            AutoCreateEntity entity = AutoCreateEntity.builder().date(LocalDateTime.now()).build();
            list.add(repository.save(entity));
        }
    }


    @Test
    void save() {

    }


    @AfterEach
    void after() {
        repository.deleteAll();
    }


}