package com.github.spring.boot.jpa.s03_event;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

/**
 * create in 2022/12/8 17:52
 *
 * @author shishaodong
 * @version 0.0.1
 */
@ActiveProfiles("junit")
@DataJpaTest
@Import(UserDomainService.class)
@Rollback(value = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IUserS03RepositoryTest {

    @Resource
    private UserDomainService domainService;

    @Resource
    private IUserS03Repository repository;

    @Test
    void save() {
        UserS03Entity domain = UserS03Entity.builder().username(RandomStringUtils.randomAlphabetic(6)).build();
        repository.save(domain);
        Mockito.verify(domainService, times(1)).userEvent(any());
    }

}