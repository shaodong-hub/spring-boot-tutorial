package com.github.spring.boot.validation.s09_message;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Past;
import java.time.LocalDate;

/**
 * create in 2021/5/13 11:29 下午
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

    @Length(min = 5, max = 10, message = "输入的用户名: ${validatedValue} 不符合要求, 用户名长度必须在{min}和{max}之间")
    String username;

    @Past(message = "{user.message.birthday}")
    LocalDate birthday;

}