package com.github.spring.boot.redis.infrastructure.repository;

import com.github.spring.boot.redis.domain.repository.IHashRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * create in 2023/3/30 10:16
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Repository
@RequiredArgsConstructor
public class HashRepositoryImpl implements IHashRepository {

    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public int add(String data) {
        return stringRedisTemplate.opsForHyperLogLog().add("HyperLogLog", data).intValue();
    }
}
