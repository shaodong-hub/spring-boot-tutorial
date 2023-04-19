package com.github.spring.boot.jpa.s05_jpql;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 * create in 2022/12/14 21:39
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Entity
@Table(name = "S05")
@DynamicInsert
@DynamicUpdate
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserS05Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT COMMENT 'id'")
    Long id;

    @Comment("用户名")
    @Column(name = "username", nullable = false, columnDefinition = "CHAR(50)")
    String username;

    @Column(name = "age", nullable = false, columnDefinition = "SMALLINT COMMENT 'age'")
    Integer age;

    @Column(name = "last_login_date", nullable = false, columnDefinition = "datetime COMMENT 'last_login_date'")
    LocalDateTime lastLoginDate;

    @Column(name = "login_count", nullable = false, columnDefinition = "INT COMMENT 'login_count'")
    Integer loginCount;

    @Type(JsonType.class)
    @Column(columnDefinition = "JSON")
    AddressValue address;

    @Column(name = "status", nullable = false, columnDefinition = "TINYINT COMMENT 'login_count'")
    Integer status;

}
