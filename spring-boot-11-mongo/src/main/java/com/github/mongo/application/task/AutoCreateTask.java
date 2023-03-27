package com.github.mongo.application.task;

import com.github.mongo.domain.entity.AutoCreateEntity;
import com.github.mongo.domain.repository.IAutoCreateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


/**
 * create in 2023/3/27 14:09
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AutoCreateTask {

    private final IAutoCreateRepository repository;

    @Scheduled(fixedRate = 1)
    public void task() {
        log.info("AutoCreateTask");
        repository.save(AutoCreateEntity.builder().date(LocalDateTime.now()).build());
    }
}
