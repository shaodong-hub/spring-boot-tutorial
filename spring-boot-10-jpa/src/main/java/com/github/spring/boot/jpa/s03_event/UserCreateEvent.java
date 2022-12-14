package com.github.spring.boot.jpa.s03_event;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * create in 2022/12/8 16:53
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Data
@AllArgsConstructor
public class UserCreateEvent {

    private Long id;

    private String username;

}
