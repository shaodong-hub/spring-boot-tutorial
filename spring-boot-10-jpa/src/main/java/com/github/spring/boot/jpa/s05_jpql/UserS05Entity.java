package com.github.spring.boot.jpa.s05_jpql;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

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
@TypeDef(name = "JSON", typeClass = JsonStringType.class)
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

    @Type(type = "JSON")
    @Column(columnDefinition = "JSON")
    AddressValue address;

    @Column(name = "status", nullable = false, columnDefinition = "TINYINT COMMENT 'login_count'")
    Integer status;

}
