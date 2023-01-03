package com.github.spring.boot.jpa.s04_projection;

import lombok.ToString;
import lombok.Value;

/**
 * create in 2023/1/4 01:14
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Value
@ToString
public class UserSimpleVO {

    Long id;

    String username;
}
