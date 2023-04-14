package com.github.spring.boot.jpa.s05_jpql;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * create in 2022/12/14 21:50
 *
 * @author shishaodong
 * @version 0.0.1
 */
@ActiveProfiles("junit")
@DataJpaTest
@Sql("classpath:db/S05.sql")
@Rollback(value = false)
@SqlMergeMode(SqlMergeMode.MergeMode.OVERRIDE)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IUserS05RepositoryTest {

    @Resource
    private IUserS05Repository repository;

    ObjectMapper objectMapper = new ObjectMapper();
    {
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    void findAll() throws JsonProcessingException {
        Page<UserS05Entity> page = repository.findAll(Pageable.unpaged());
        String s = objectMapper.writeValueAsString(page);
        System.out.println(s);
    }

    @Test
    void findAllByAvg() {
        Page<IUserVO> page = repository.findAllByAvg(Pageable.unpaged(), IUserVO.class);
        page.forEach(iUserVO -> System.out.println(iUserVO.getUsername()));
        Assertions.assertEquals(1L, page.getTotalElements());
    }

    @Test
    void updateLastLoginDateByUserId() {
        int count = repository.updateLastLoginDateByUserId(1L);
        Assertions.assertEquals(1L, count);
        Optional<UserS05Entity> optional = repository.findById(1L);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertTrue(optional.get().getLastLoginDate().isBefore(LocalDateTime.now()));
    }

    @Test
    void updateLoginCountByUserId() {
        int count = repository.updateLoginCountByUserId(1L);
        Assertions.assertEquals(1L, count);
        Optional<UserS05Entity> optional = repository.findById(1L);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertEquals(2, optional.get().getLoginCount());
    }

    @Test
    void replace() {
        int replace = repository.replace(4L, "test_name");
        Assertions.assertEquals(1, replace);
        Optional<UserS05Entity> optional = repository.findById(4L);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertEquals("test_name", optional.get().getAddress().getPath());
    }



    interface IUserVO {

        Long getId();

        String getUsername();
    }
}