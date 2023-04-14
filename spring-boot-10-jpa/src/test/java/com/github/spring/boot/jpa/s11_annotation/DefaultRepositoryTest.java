package com.github.spring.boot.jpa.s11_annotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;

/**
 * create in 2023/4/13 21:39
 *
 * @author shishaodong
 * @version 0.0.1
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("junit")
class DefaultRepositoryTest {

    @Resource
    DefaultRepository repository;

    @Test
    @Rollback(value = false)
    void save() {
        DefaultEntity entity = repository.save(new DefaultEntity());
        Assertions.assertEquals(2, entity.getType());
    }


}