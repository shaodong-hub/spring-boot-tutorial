package com.github.spring.boot.validation.s13_composition;

import com.github.spring.boot.validation.s13_composition.annotation.Composition;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

/**
 * create in 2021/5/14 3:35 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */


@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreateCommand {

    @Composition
    String identity;

}
