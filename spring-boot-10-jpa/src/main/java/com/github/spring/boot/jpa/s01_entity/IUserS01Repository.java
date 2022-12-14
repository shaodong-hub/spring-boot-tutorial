package com.github.spring.boot.jpa.s01_entity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * create in 2022/12/14 20:54
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IUserS01Repository extends JpaRepository<UserS01Entity, Long> {
}
