package com.github.spring.boot.jpa.s04_projection;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;

import java.util.Optional;

/**
 * create in 2022/12/14 20:26
 *
 * @author shishaodong
 * @version 0.0.1
 */
@ActiveProfiles("junit")
@DataJpaTest
@Import(IUserComplexVO.UserService.class)
@Rollback
@Sql("classpath:db/S04.sql")
@SqlMergeMode(SqlMergeMode.MergeMode.MERGE)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IUserS04RepositoryTest {

    @Resource
    private IUserS04Repository repository;

    @Test
    void findByIdSimple1() {
        Optional<IUserSimpleVO> optional = repository.findById(1L, IUserSimpleVO.class);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertEquals(1L, optional.get().getId());
        Assertions.assertEquals("username1", optional.get().getUsername());
    }

    @Test
    void findByIdSimple2() {
        Optional<UserSimpleVO> optional = repository.findById(1L, UserSimpleVO.class);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertEquals(1L, optional.get().getId());
        Assertions.assertEquals("username1", optional.get().getUsername());
    }

    @Test
    void findByIdComplex() {
        Optional<IUserComplexVO> optional = repository.findById(1L, IUserComplexVO.class);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertEquals(1L, optional.get().getId());
        Assertions.assertEquals("username1" + " do something", optional.get().getUsername());
    }

    @Test
    void findAll() {
        Page<IUserSimpleVO> page = repository.findAllBy(Pageable.unpaged(), IUserSimpleVO.class);
        Assertions.assertEquals(3L, page.getTotalElements());
    }


}