package com.github.mongo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * create in 2023/3/27 11:20
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "data_with_ttl")
@CompoundIndexes({@CompoundIndex(name = "index", def = "{'message':1,'field':1}")})
@TypeAlias("DataWithTtlEntity")
public class DataWithTtlEntity {

    @Id
    private String id;

    @Indexed
    private String name;

    private String field;

    @Field("desc")
    private String message;

    /**
     * 创建 ttl 的集合, 创建改集合时需要设置 ttl 字段, 特别要注意, 该字段 存入的数据类型为 Date
     * 用来设置集合中 文档到期的秒数。如果没有设置，则默认为-1
     * 60 秒之后过期
     */
    @Indexed(name = "IDX_TTL", expireAfterSeconds = 60)
    private Date expire;

    @CreatedDate
    @Field("created_date")
    private Date createdDate;

    @LastModifiedDate
    @Field("last_modified_date")
    private Date lastModifiedDate;

    /**
     * 被 {@link Transient} 标记的字段将不会保存到数据库中
     */
    @Transient
    private Long temp;

    /**
     * 版本号
     */
    @Version
    private Long version;
}
