package com.github.cache.service;

import com.github.cache.common.UserInfoCreateCommand;
import com.github.cache.common.UserInfoUpdateCommand;
import com.github.cache.common.UserInfoVO;
import com.github.cache.entity.UserInfoEntity;
import com.github.cache.mapper.UserMapper;
import com.github.cache.repository.IUserDetailRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * create in 2023/5/31 14:50
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "user-cache")
public class UserService {

    private final IUserDetailRepository repository;



    @Cacheable(key = "#a0")
    public UserInfoVO findByUsername(String username) {
        Optional<UserInfoVO> optional = repository.findByUsername(username);
        UserInfoVO user = optional.orElseThrow(EntityNotFoundException::new);
        log.info("UserInfoVO - findByUsername:{} - {}", username, user);
        return user;
    }

    @Cacheable(key = "#a0")
    public UserInfoVO findByPhone(String phone) {
        Optional<UserInfoVO> optional = repository.findByPhone(phone);
        UserInfoVO user = optional.orElseThrow(EntityNotFoundException::new);
        log.info("UserInfoVO - findByPhone:{} - {}", phone, user);
        return user;
    }

    @Caching(put = {
            @CachePut(key = "#result.username()"),
            @CachePut(key = "#result.phone()")
    })
    public UserInfoVO createUser(@NotNull UserInfoCreateCommand command) {
        UserInfoEntity entity = new UserInfoEntity(command.username(), command.phone());
        UserInfoEntity saved = repository.save(entity);
        UserInfoVO vo = new UserInfoVO(saved.getUsername(), saved.getPhone());
        log.info("UserInfoVO - createUser:{} - {}", vo.username(), vo.phone());
        return vo;
    }

    @Caching(put = {
            @CachePut(key = "#result.username()"),
            @CachePut(key = "#result.phone()")
    })
    @Transactional(rollbackFor = Exception.class)
    public UserInfoVO updateUser(@NotNull UserInfoUpdateCommand command) {
        Optional<UserInfoEntity> optional = repository.findById(command.id());
        UserInfoEntity entity = optional.orElseThrow(EntityNotFoundException::new);
        UserInfoVO mapped = UserMapper.map(entity.update(command));
        log.info("UserInfoVO - updateUser:{} - {}", mapped.username(), mapped.phone());
        return mapped;
    }

    @Caching(evict = {
            @CacheEvict(key = "#result.username()"),
            @CacheEvict(key = "#result.phone()")
    })
    public UserInfoVO delete(String username) {
        Optional<UserInfoVO> optional = repository.findByUsername(username);
        UserInfoVO user = optional.orElseThrow(EntityNotFoundException::new);
        log.info("UserInfoVO - delete:{}", username);
        return user;
    }
}
