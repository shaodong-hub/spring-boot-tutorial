package com.github.spring.boot.jpa.s10_one_to_one;

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
 * create in 2022/12/28 14:35
 *
 * @author shishaodong
 * @version 0.0.1
 */
@ActiveProfiles("junit")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IUserS10RepositoryTest {

    @Resource
    IUserS10Repository repository;

    @Test
    @Rollback(value = false)
    @Sql(scripts = "classpath:db/S10.sql")
    @SqlMergeMode(SqlMergeMode.MergeMode.OVERRIDE)
    void save() {
        UserS10Entity entity = UserS10Entity.builder()
                .username("junit_username")
                .address(AddressS10Entity.builder().city("junit_city").code("junit_code").build())
                .build();
        UserS10Entity save = repository.save(entity);
        Assertions.assertEquals("junit_username", save.getUsername());
        Assertions.assertEquals("junit_city", save.getAddress().getCity());
        Assertions.assertEquals("junit_code", save.getAddress().getCode());
    }

    @Test
    @Rollback(value = false)
    @Sql(scripts = "classpath:db/S10.sql")
    @SqlMergeMode(SqlMergeMode.MergeMode.OVERRIDE)
    void delete() {
        repository.deleteById(1L);
        Optional<UserS10Entity> optional = repository.findById(1L);
        Assertions.assertFalse(optional.isPresent());
    }


    @Test
    @Rollback(value = false)
    @Sql(scripts = "classpath:db/S10.sql")
    @SqlMergeMode(SqlMergeMode.MergeMode.OVERRIDE)
    void findById() {
        Optional<UserS10Entity> optional = repository.findById(3L);
        Assertions.assertTrue(optional.isPresent());
        AddressS10Entity address = optional.get().getAddress();
        System.out.println();
    }
}