package com.github.spring.boot.jpa.s09_many_to_many;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;

import java.util.Optional;

/**
 * create in 2023/1/3 11:03
 *
 * @author shishaodong
 * @version 0.0.1
 */
@ActiveProfiles("junit")
@SpringBootTest
@Sql("classpath:db/S09.sql")
@Rollback(value = false)
@SqlMergeMode(SqlMergeMode.MergeMode.OVERRIDE)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IUserS09RepositoryTest {

    @Resource
    IUserS09Repository repository;

    @Test
    void findById() {
        Optional<UserS09Entity> optional = repository.findById(1L);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertEquals(1L, optional.get().getId());
        Assertions.assertEquals(2, optional.get().getRoles().size());
    }
}