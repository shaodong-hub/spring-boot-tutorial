package com.github.spring.boot.jpa.s01_entity;

import com.github.spring.boot.jpa.s01_entity.value.UsernameRecord;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;

import java.util.Optional;


/**
 * create in 2022/12/14 20:55
 *
 * @author shishaodong
 * @version 0.0.1
 */
@ActiveProfiles("junit")
@DataJpaTest
@Sql("classpath:db/S01.sql")
@Rollback(value = false)
@SqlMergeMode(SqlMergeMode.MergeMode.OVERRIDE)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IUserS01RepositoryTest {

    @Resource
    private IUserS01Repository repository;

    @Test
    void save() {
        UserS01Entity build1 = UserS01Entity.builder().username(new UsernameRecord("test_username")).build();
        // Hibernate: insert into s01 (username) values (?)
        repository.save(build1);
        Optional<UserS01Entity> optional = repository.findById(1L);
        Assertions.assertTrue(optional.isPresent());
        UserS01Entity entity = optional.get();
        entity = entity.updateUsername(new UsernameRecord("updated_name"));
        // Hibernate: update s01 set username=? where id=?
        UserS01Entity save = repository.save(entity);
        Assertions.assertEquals("updated_name", save.getUsername().getUsername());
    }
}