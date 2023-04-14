package com.github.spring.boot.jpa.s08_one_to_many.where;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * create in 2023/4/13 21:04
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IOneRepository extends JpaRepository<OneEntity, Long> {

}
