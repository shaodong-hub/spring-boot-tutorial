package com.github.spring.boot.jpa.s06_specification;

import com.github.spring.boot.jpa.s05_jpql.UserS05Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * create in 2022/12/14 22:16
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IUserS06Repository extends JpaRepository<UserS05Entity, Long>, JpaSpecificationExecutor<UserS05Entity> {

}
