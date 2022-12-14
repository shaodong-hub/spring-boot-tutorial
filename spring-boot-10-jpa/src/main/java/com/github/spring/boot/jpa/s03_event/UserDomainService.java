package com.github.spring.boot.jpa.s03_event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;


/**
 * create in 2022/12/8 16:52
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserDomainService {

    private final IUserS03Repository repository;

    @TransactionalEventListener(UserCreateEvent.class)
    public void userEvent(UserCreateEvent event) {
        log.info("{}", event);
    }

    public UserS03Entity create() {
        UserS03Entity domain = UserS03Entity.builder().username(RandomStringUtils.randomAlphabetic(6)).build();
        return repository.save(domain);
    }
}
