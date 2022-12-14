package com.github.spring.boot.jpa.s02_converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * create in 2022/12/14 14:42
 *
 * @author shishaodong
 * @version 0.0.1
 */
@ActiveProfiles("junit")
@DataJpaTest
@Rollback(value = false)
@Sql("classpath:db/S02.sql")
@SqlMergeMode(SqlMergeMode.MergeMode.OVERRIDE)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IUserS02RepositoryTest {

    @Resource
    private IUserS02Repository repository;

    @Test
    void findById() {
        Optional<UserS02Entity> optional = repository.findById(1L);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertEquals(1L, optional.get().getId());
    }
}