package com.github.spring.boot.jpa.s07_transaction;

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

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * create in 2022/12/15 14:44
 *
 * @author shishaodong
 * @version 0.0.1
 */
@ActiveProfiles("junit")
@SpringBootTest
@Sql("classpath:db/S07.sql")
@Rollback(value = false)
@SqlMergeMode(SqlMergeMode.MergeMode.OVERRIDE)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserS07ServiceTest {

    @Resource
    private UserS07Service service;

    @Resource
    private IUserS07Repository repository;

    @Test
    void update1() {
        service.update1(new UsernameUpdateCommand(1L, "update_username"));
        Optional<UserS07Entity> optional = repository.findById(1L);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertEquals("update_username", optional.get().getUsername());
    }

    @Test
    void update2() {
        assertThrows(Exception.class, () -> service.update2(new UsernameUpdateCommand(1L, "update_username")));
        Optional<UserS07Entity> optional = repository.findById(1L);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertEquals("update_username", optional.get().getUsername());
    }


    @Test
    void timeout() {
        assertThrows(Exception.class, () -> service.timeout(new UsernameUpdateCommand(1L, "update_username")));
        Optional<UserS07Entity> optional = repository.findById(1L);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertEquals("username1", optional.get().getUsername());
    }


}