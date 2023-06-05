package com.github.cache.repository;

import com.github.cache.common.UserInfoVO;
import com.github.cache.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * create in 2023/5/31 15:26
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IUserDetailRepository extends JpaRepository<UserInfoEntity, Long>, JpaSpecificationExecutor<UserInfoEntity> {

    Optional<UserInfoVO> findByUsername(String username);

    Optional<UserInfoVO> findByPhone(String phone);

}
