package com.github.spring.boot.validation.s04_custom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * create in 2021/5/19 4:10 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Repository
public class UserInfoRepository {

    public boolean existByUsername(String username) {
        return true;
    }

}
