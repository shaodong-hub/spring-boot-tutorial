package com.github.spring.boot.validation.s02_group;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreateCommand {

    @NotBlank(groups = {Group1.class, Group2.class})
    @Length(min = 5, max = 20, groups = {Group1.class, Group2.class})
    String username;

    @Email(groups = {Group1.class, Group2.class})
    String email;

    @NotNull(groups = {Group1.class})
    @Past(groups = {Group1.class})
    LocalDate birthday;

}