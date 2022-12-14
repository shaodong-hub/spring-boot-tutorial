package com.github.spring.boot.jpa.s08_one_to_many;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
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
 * create in 2022/12/14 13:06
 *
 * @author shishaodong
 * @version 0.0.1
 */
@ActiveProfiles("junit")
@DataJpaTest
@Rollback(value = false)
@Sql("classpath:db/S08.sql")
@SqlMergeMode(SqlMergeMode.MergeMode.OVERRIDE)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IUserS08RepositoryTest {

    @Resource
    private IUserS08Repository repository;

    @Test
    void findById() {
        Optional<UserS08Entity> optional = repository.findById(1L);
        optional.ifPresent(this::extracted);
    }

    @SneakyThrows
    private void extracted(UserS08Entity users08Entity) {
        System.out.println("----------- " + new ObjectMapper().writeValueAsString(users08Entity));
    }
}