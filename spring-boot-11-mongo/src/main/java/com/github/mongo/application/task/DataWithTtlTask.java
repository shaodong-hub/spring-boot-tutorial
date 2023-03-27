package com.github.mongo.application.task;

import com.github.mongo.domain.entity.DataWithTtlEntity;
import com.github.mongo.domain.repository.IDataWithTtlRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * create in 2023/3/27 14:09
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DataWithTtlTask {

    private final IDataWithTtlRepository repository;

    @Scheduled(fixedRate = 1)
    public void task() {
        log.info("DataWithTtlTask");
        repository.save(DataWithTtlEntity.builder().build());
    }
}
