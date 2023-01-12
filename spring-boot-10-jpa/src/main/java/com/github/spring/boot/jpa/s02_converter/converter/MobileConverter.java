package com.github.spring.boot.jpa.s02_converter.converter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import javax.persistence.AttributeConverter;
import java.util.function.Supplier;

/**
 * create in 2022/12/14 14:28
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@RequiredArgsConstructor
public class MobileConverter implements AttributeConverter<String, String> {

    private static final String ENCRYPT = "encrypt:";

    private final ObjectProvider<IPasswordProvider> objectProvider;

    @Override
    public String convertToDatabaseColumn(@NotNull String attribute) {
        log.error("------------- {}", objectProvider.getIfAvailable(() -> () -> "----1234").getPassword());
        String mobile = StringUtils.isBlank(attribute) ? "" : attribute;
        log.info("convertToDatabaseColumn {}", mobile);
        return ENCRYPT + mobile;
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        String remove = StringUtils.remove(dbData, ENCRYPT);
        log.info("convertToEntityAttribute {}", remove);
        return remove;
    }

}
