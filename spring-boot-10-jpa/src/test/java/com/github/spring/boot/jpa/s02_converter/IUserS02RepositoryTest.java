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
import javax.persistence.EntityManager;
import java.util.Optional;

/**
 * create in 2022/12/14 14:42
 *
 * @author shishaodong
 * @version 0.0.1
 */
@ActiveProfiles("junit")
@DataJpaTest
@SqlMergeMode(SqlMergeMode.MergeMode.OVERRIDE)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IUserS02RepositoryTest {

    @Resource
    private IUserS02Repository repository;

    @Resource
    private EntityManager entityManager;

    @Test
    @Sql("classpath:db/S02.sql")
    void findById() {
        Optional<UserS02Entity> optional = repository.findById(1L);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertEquals(1L, optional.get().getId());
    }

    @Test
    @Rollback(value = false)
    void save() {
        UserS02Entity entity = UserS02Entity.builder().identity("identity_123").contacts(new ContactsRecord("test_name1", "test_name2")).build();
        UserS02Entity save = repository.save(entity);
        entityManager.clear();
        Optional<UserS02Entity> optional = repository.findById(1L);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertEquals("TEST_NAME1", optional.get().getContacts().getFirstname());
        Assertions.assertEquals("test_name2", optional.get().getContacts().getLastname());

        Optional<UserS02Entity> optional2 = repository.findByContacts(new ContactsRecord(null, "test_name2"));
        Assertions.assertTrue(optional2.isPresent());
        Assertions.assertEquals("TEST_NAME1", optional2.get().getContacts().getFirstname());
        Assertions.assertEquals("test_name2", optional2.get().getContacts().getLastname());
    }
}