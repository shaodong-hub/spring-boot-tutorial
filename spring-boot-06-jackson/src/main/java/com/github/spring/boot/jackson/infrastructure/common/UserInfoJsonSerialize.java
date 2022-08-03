package com.github.spring.boot.jackson.infrastructure.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.spring.boot.jackson.infrastructure.serialize.MobileDeserializer;
import com.github.spring.boot.jackson.infrastructure.serialize.MobileSerializer;
import lombok.Data;

import java.util.Set;

/**
 * create in 2022/8/1 09:54
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Data
public class UserInfoJsonSerialize {

    private String username;

    @JsonSerialize(using = MobileSerializer.class)
    @JsonDeserialize(using = MobileDeserializer.class)
    private Set<String> mobiles;

}
