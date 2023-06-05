package com.github.cache.service;

import com.github.cache.common.UserInfoCreateCommand;
import com.github.cache.common.UserInfoUpdateCommand;
import com.github.cache.common.UserInfoVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;

import java.util.stream.IntStream;

/**
 * create in 2023/6/1 14:50
 *
 * @author shishaodong
 * @version 0.0.1
 */
@ActiveProfiles("junit")
@SpringBootTest
@Sql("classpath:db/data.sql")
@Rollback(value = false)
@SqlMergeMode(SqlMergeMode.MergeMode.OVERRIDE)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserServiceTest {

    @SpyBean
    UserService userService;

    @Test
    void findByUsername() {
        UserInfoVO service = userService.findByUsername("username-01");
        Assertions.assertEquals("username-01", service.username());
        IntStream.range(0, 5).forEach(i -> userService.findByUsername("username-01"));
        Mockito.verify(userService, Mockito.times(1)).findByUsername("username-01");
    }

    @Test
    void findByPhone() {
        UserInfoVO service = userService.findByPhone("18812345678");
        Assertions.assertEquals("username-01", service.username());
        IntStream.range(0, 5).forEach(i -> userService.findByPhone("18812345678"));
        Mockito.verify(userService, Mockito.times(1)).findByPhone("18812345678");
    }

    @Test
    void createUser() {
        userService.createUser(new UserInfoCreateCommand("username-02", "18812345670"));


    }

    @Test
    void updateUser() {
        UserInfoVO user = userService.updateUser(new UserInfoUpdateCommand(1L, "username-03", "18812345671"));

    }

    @Test
    void delete() {
    }
}