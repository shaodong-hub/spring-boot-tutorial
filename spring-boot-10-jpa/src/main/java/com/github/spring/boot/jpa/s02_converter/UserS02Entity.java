package com.github.spring.boot.jpa.s02_converter;


import com.github.spring.boot.jpa.s02_converter.converter.MobileConverter;
import com.github.spring.boot.jpa.s02_converter.converter.UsernameConverter;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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

    @Embedded
    @Convert(attributeName = "firstname", converter = UsernameConverter.class)
    @AttributeOverride(name = "firstname", column = @Column(nullable = false, columnDefinition = "CHAR(20) COMMENT 'firstname'"))
    @AttributeOverride(name = "lastname", column = @Column(nullable = false, columnDefinition = "CHAR(20) COMMENT 'lastname'"))
    ContactsRecord contacts;

    @Column(name = "identity", columnDefinition = "VARCHAR(32) COMMENT '身份证'")
    String identity;

    @Convert(converter = MobileConverter.class)
    @Column(columnDefinition = "VARCHAR(32) COMMENT '手机号'")
    String mobile;
}
