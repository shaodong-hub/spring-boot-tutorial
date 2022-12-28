package com.github.spring.boot.jpa.s02_converter.converter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;

/**
 * create in 2022/12/14 14:31
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
public class UsernameConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String attribute) {
        String upperCase = StringUtils.upperCase(StringUtils.isBlank(attribute) ? "" : attribute);
        log.info("convertToDatabaseColumn {} {}", attribute, upperCase);
        return upperCase;
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        log.info("convertToEntityAttribute {}", dbData);
        return dbData;
    }
}
