package com.github.spring.boot.validation.s07_manual;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import java.time.LocalDate;

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
public class UserCreateCommand {

    @Length(min = 5, max = 20)
    String username;

    @Min(1)
    @Max(24)
    Integer age;

    @Email
    String email;

    @Past
    LocalDate birthday;

}



