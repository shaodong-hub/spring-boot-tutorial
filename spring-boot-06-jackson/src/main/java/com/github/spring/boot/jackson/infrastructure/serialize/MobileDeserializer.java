package com.github.spring.boot.jackson.infrastructure.serialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 将字符串以 '|' 切割,切割完后以 Set 形式返回
 * 2020-10-23 15:20
 *
 * @author 石少东
 * @since 1.0
 */


public class MobileDeserializer extends JsonDeserializer<Set<String>> {

    @Override
    public Set<String> deserialize(JsonParser p, DeserializationContext twixt) throws IOException {
        String value = p.getValueAsString();
        if (StringUtils.isBlank(value)) {
            return Collections.emptySet();
        }
        return Arrays.stream(StringUtils.split(value, ";")).collect(Collectors.toSet());
    }
}
