package com.github.spring.boot.jpa.s11_annotation;

import com.github.spring.boot.jpa.s10_one_to_one.AddressS10Entity;
import com.github.spring.boot.jpa.s10_one_to_one.IUserS10Repository;
import com.github.spring.boot.jpa.s10_one_to_one.UserS10Entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;

import javax.annotation.Resource;

import java.util.Optional;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

/**
 * create in 2023/4/13 21:20
 *
 * @author shishaodong
 * @version 0.0.1
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("junit")
class ImmutableRepositoryTest {

    @Resource
    ImmutableRepository repository;

    @Test
    @Rollback(value = false)
    @Sql(scripts = "classpath:db/S11.SQL")
    @SqlMergeMode(SqlMergeMode.MergeMode.OVERRIDE)
    void findById() {
        Optional<ImmutableEntity> optional = repository.findById(1L);
        optional.ifPresent(System.out::println);
    }


    @Test
    @Rollback(value = false)
    @Sql(scripts = "classpath:db/S11.SQL")
    @SqlMergeMode(SqlMergeMode.MergeMode.OVERRIDE)
    void update() {
        Optional<ImmutableEntity> optional = repository.findById(1L);
        Assertions.assertTrue(optional.isPresent());
        ImmutableEntity entity = optional.get();
        entity.updateMessage("message_update");
        repository.save(entity);
    }
}