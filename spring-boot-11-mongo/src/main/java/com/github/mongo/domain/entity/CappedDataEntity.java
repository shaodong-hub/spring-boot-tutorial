package com.github.mongo.domain.entity;

import com.github.mongo.infrastructure.config.ReversingValueConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.convert.ValueConverter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * create in 2023/3/27 14:23
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "capped_data")
@TypeAlias("CappedDataEntity")
public class CappedDataEntity {

    @Id
    private String id;

    @ValueConverter(ReversingValueConverter.class)
    private String phone;

    private LocalDateTime localDateTime;
}
