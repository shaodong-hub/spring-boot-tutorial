package com.github.spring.boot.jpa.s06_specification;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;

import javax.annotation.Resource;

/**
 * create in 2022/12/14 22:18
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
class IUserS06RepositoryTest {

    @Resource
    private IUserS06Repository repository;

    @Test
    void findBy() {



    }


}