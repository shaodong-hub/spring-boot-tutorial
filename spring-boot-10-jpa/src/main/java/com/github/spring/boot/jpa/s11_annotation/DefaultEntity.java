package com.github.spring.boot.jpa.s11_annotation;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

/**
 * create in 2023/4/13 21:12
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "s11_default")
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT COMMENT 'id'")
    Long id;

    /**
     * {@link Comment} 生成 SQL 默认值, 相当于 columnDefinition = "COMMENT '类型' "
     * {@link ColumnDefault} 生成 SQL 默认值, 相当于 columnDefinition = "DEFAULT 2"
     */
    @Getter
    @Comment("类型")
    @ColumnDefault("2")
    @Column(columnDefinition = "TINYINT")
    Integer type;

    @Comment("创建时间")
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time", updatable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    LocalDateTime createTime;
}
