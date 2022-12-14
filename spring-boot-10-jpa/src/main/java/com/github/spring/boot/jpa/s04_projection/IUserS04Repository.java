package com.github.spring.boot.jpa.s04_projection;

import com.github.spring.boot.jpa.s03_event.UserS03Entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * create in 2022/12/14 20:26
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IUserS04Repository extends JpaRepository<UserS03Entity, Long> {

    <T> Optional<T> findById(long id, Class<T> clz);

    <T> Page<T> findAllBy(Pageable pageable, Class<T> clz);

}
