package com.github.mongo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * create in 2023/3/27 11:27
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "#{@auto.getName()}")
@TypeAlias("AutoCreateEntity")
public class AutoCreateEntity {

    @Id
    private String id;

    @Indexed
    private LocalDateTime date;

}
