package com.github.spring.boot.jpa.s02_converter.converter;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;

/**
 * create in 2022/12/14 14:31
 *
 * @author shishaodong
 * @version 0.0.1
 */
public class UsernameConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return StringUtils.isBlank(attribute) ? "" : StringUtils.upperCase(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return StringUtils.isBlank(dbData) ? "" : StringUtils.lowerCase(dbData);
    }
}
