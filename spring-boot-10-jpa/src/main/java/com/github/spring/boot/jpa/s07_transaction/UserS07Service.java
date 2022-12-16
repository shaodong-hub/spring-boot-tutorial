package com.github.spring.boot.jpa.s07_transaction;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * create in 2022/12/15 09:25
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Service
@Validated
@RequiredArgsConstructor
public class UserS07Service {

    private final IUserS07Repository repository;

    @Transactional(rollbackFor = {Exception.class})
    public void update1(@Valid @NotNull UsernameUpdateCommand command) {
        Optional<UserS07Entity> optional = repository.findById(command.getId());
        UserS07Entity entity = optional.orElseThrow(() -> new RuntimeException("user id not found!"));
        entity.updateUsername(command.getUsername());
    }

    @Transactional(rollbackFor = {Exception.class})
    public void update2(@Valid @NotNull UsernameUpdateCommand command) {
        Optional<UserS07Entity> optional = repository.findById(command.getId());
        UserS07Entity entity = optional.orElseThrow(() -> new RuntimeException("user id not found!"));
        entity.updateUsername(command.getUsername());
    }

    @Transactional(rollbackFor = {Exception.class}, timeout = 2, propagation = Propagation.REQUIRED)
    @SneakyThrows(InterruptedException.class)
    public void timeout(@Valid @NotNull UsernameUpdateCommand command) {
        Optional<UserS07Entity> optional = repository.findById(command.getId());
        UserS07Entity entity = optional.orElseThrow(() -> new RuntimeException("user id not found!"));
        entity.updateUsername(command.getUsername());
        TimeUnit.SECONDS.sleep(3);
    }
}
