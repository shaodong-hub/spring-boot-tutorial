package com.github.spring.boot.jpa.s01_entity.value;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * create in 2021/7/15 9:38 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class UsernameRecord implements Serializable {

    private static final long serialVersionUID = 4191347916528602598L;

    String username;
}
