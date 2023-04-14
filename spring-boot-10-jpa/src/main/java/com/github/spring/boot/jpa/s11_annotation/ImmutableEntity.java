package com.github.spring.boot.jpa.s11_annotation;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Immutable;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * create in 2023/4/13 21:12
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Entity
@Immutable
@DynamicInsert
@Table(name = "s11_immutable")
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImmutableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT COMMENT 'id'")
    Long id;

    @Comment("信息")
    @Column(name = "message", columnDefinition = "VARCHAR(32)")
    String message;

    @Comment("类型")
    @ColumnDefault("1")
    @Column(name = "type", columnDefinition = "TINYINT")
    Integer type;

    @Comment("创建时间")
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time", updatable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createTime;

    public void updateMessage(String message) {
        this.message = message;
    }

}
