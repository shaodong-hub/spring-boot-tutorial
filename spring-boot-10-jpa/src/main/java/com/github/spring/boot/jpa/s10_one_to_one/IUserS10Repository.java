package com.github.spring.boot.jpa.s10_one_to_one;

import com.github.spring.boot.jpa.s08_one_to_many.UserS08Entity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * create in 2022/12/14 13:04
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IUserS10Repository extends JpaRepository<UserS10Entity, Long> {

}
