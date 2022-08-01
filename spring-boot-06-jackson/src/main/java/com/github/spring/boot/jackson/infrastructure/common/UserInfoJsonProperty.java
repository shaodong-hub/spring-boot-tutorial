package com.github.spring.boot.jackson.infrastructure.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * create in 2022/7/31 22:34
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Data
public class UserInfoJsonProperty {

    @JsonProperty("account")
    private String username;

    private String note;
}
