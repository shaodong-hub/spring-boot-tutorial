package com.github.spring.boot.jpa.s07_transaction;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



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
