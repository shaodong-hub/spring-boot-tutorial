package com.github.mongo.infrastructure.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.convert.PropertyValueConverter;
import org.springframework.data.convert.ValueConversionContext;
import org.springframework.data.mongodb.core.mapping.MongoPersistentProperty;


/**
 * create in 2023/3/27 14:40
 *
 * @author shishaodong
 * @version 0.0.1
 */
public class ReversingValueConverter implements PropertyValueConverter<String, String, ValueConversionContext<MongoPersistentProperty>> {

    @Override
    public String read(String value, ValueConversionContext context) {
        if (StringUtils.startsWith(value, "test_")) {
            return StringUtils.remove(value, "test_");
        }
        return value;
    }

    @Override
    public String write(String value, ValueConversionContext context) {
        if (StringUtils.isBlank(value)) {
            return "test_";
        }
        return "test_" + value;
    }
}
