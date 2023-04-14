package com.github.mongo.application.task;

import com.github.mongo.domain.entity.CappedDataEntity;
import com.github.mongo.domain.repository.ICappedDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * create in 2023/3/27 14:33
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CappedDataTask {

    private final ICappedDataRepository repository;

    @Scheduled(fixedRate = 1)
    public void task() {
        log.info("CappedDataTask");
        repository.save(CappedDataEntity.builder().localDateTime(LocalDateTime.now()).phone(RandomStringUtils.randomAlphabetic(6)).build());
    }
}
