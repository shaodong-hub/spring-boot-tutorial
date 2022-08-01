package com.github.spring.boot.jackson.infrastructure.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

/**
 * 将 Set 中字符串 以 | 拼接
 * 2020-10-23 15:31
 *
 * @author 石少东
 * @since 1.0
 */


public class MobileSerializer extends JsonSerializer<Set<String>> {

    @Override
    public void serialize(@NotNull Set<String> value, @NotNull JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String res = StringUtils.join(Arrays.stream(value.toArray()).distinct().toArray(), "|");
        gen.writeObject(res);
    }
}
