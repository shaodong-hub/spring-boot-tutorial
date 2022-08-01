package com.github.spring.boot.jackson.infrastructure.common;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * create in 2022/8/1 10:41
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Data
@JsonPropertyOrder(alphabetic = true)
public class UserInfoJsonPropertyOrder {

    private String username;

    private Integer age;

    private String note;

}
