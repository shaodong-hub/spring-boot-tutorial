package com.github.spring.boot.jpa.s02_converter;


import com.github.spring.boot.jpa.s02_converter.converter.UsernameConverter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * create in 2022/12/8 16:44
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "S02")
public class UserS02Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT COMMENT 'id'")
    Long id;

    @Column(name = "username", columnDefinition = "VARCHAR(32) COMMENT '姓名'", unique = true)
    @Convert(converter = UsernameConverter.class)
    String username;

    @Embedded
    @AttributeOverride(name = "mobile", column = @Column(nullable = false, columnDefinition = "CHAR(100) COMMENT 'mobile'"))
    MobileRecord mobile;
}
