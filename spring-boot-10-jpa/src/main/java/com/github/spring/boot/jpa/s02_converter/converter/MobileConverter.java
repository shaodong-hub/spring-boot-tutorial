package com.github.spring.boot.jpa.s02_converter.converter;

import com.github.spring.boot.jpa.s02_converter.MobileRecord;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * create in 2022/12/14 14:28
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Converter(autoApply = true)
public class MobileConverter implements AttributeConverter<MobileRecord, String> {

    private static final String ENCRYPT = "encrypt:";

    @Override
    public String convertToDatabaseColumn(@NotNull MobileRecord attribute) {
        String mobile = StringUtils.isBlank(attribute.getMobile()) ? "" : attribute.getMobile();
        log.info("convertToDatabaseColumn {}", mobile);
        return ENCRYPT + mobile;
    }

    @Override
    public MobileRecord convertToEntityAttribute(String dbData) {
        String remove = StringUtils.remove(dbData, ENCRYPT);
        log.info("convertToEntityAttribute {}", remove);
        return new MobileRecord(remove);
    }
}
