package com.github.spring.boot.validation.s06_class;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

/**
 * create in 2021/5/13 7:31 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ClassValid
public class UserCreateCommand {

    String username;

    Integer age;

    String education;
}



