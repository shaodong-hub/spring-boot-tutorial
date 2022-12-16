package com.github.spring.boot.jpa.s07_transaction;

import com.github.spring.boot.jpa.s03_event.UserS03Entity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * create in 2022/12/8 17:05
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IUserS07Repository extends JpaRepository<UserS07Entity, Long> {
}
