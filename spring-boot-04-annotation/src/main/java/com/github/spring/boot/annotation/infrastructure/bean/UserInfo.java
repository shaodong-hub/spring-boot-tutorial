package com.github.spring.boot.annotation.infrastructure.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * create in 2022/7/13 22:51
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Data
@AllArgsConstructor
public class UserInfo {

    private String name;

    private String loc;
}
