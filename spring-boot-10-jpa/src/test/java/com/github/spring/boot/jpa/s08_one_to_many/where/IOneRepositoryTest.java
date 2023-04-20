package com.github.spring.boot.jpa.s08_one_to_many.where;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;

import java.util.Optional;
import java.util.function.Consumer;


/**
 * create in 2023/4/13 21:04
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Rollback(value = false)
@ActiveProfiles("junit")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IOneRepositoryTest {

    @Resource
    IOneRepository repository;

    @Test
    @Sql(scripts = "classpath:db/S08_ONE.SQL")
    @SqlMergeMode(SqlMergeMode.MergeMode.OVERRIDE)
    void findById() {
        Optional<OneEntity> optional = repository.findById(1L);
        optional.ifPresent(System.out::println);
    }




    @Test
    @Sql(scripts = "classpath:db/S08_ONE.SQL")
    @SqlMergeMode(SqlMergeMode.MergeMode.OVERRIDE)
    void findById2() {
        Optional<OneEntity> optional = repository.findById(1L);
        optional.ifPresent(oneEntity -> {
            oneEntity.getAllList().remove(0);
            repository.save(oneEntity);
        });
    }


}