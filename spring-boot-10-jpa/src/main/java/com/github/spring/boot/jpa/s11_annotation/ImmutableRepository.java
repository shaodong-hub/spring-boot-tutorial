package com.github.spring.boot.jpa.s11_annotation;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * create in 2023/4/13 21:19
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface ImmutableRepository extends JpaRepository<ImmutableEntity, Long> {

}
