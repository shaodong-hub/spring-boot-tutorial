package com.github.spring.boot.jpa.s07_transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * create in 2022/12/15 14:27
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsernameUpdateCommand {

    @NotNull
    private Long id;

    @NotBlank
    private String username;

}
