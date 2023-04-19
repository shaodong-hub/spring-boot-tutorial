package com.github.spring.boot.jpa.s12_json;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AccessLevel;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
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
import java.util.List;

/**
 * create in 2023/4/19 14:47
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "s12_json")
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@TypeDef(name = "JSON", typeClass = JsonStringType.class)
public class UserBookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT COMMENT 'id'")
    Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(50) COMMENT '用户名'")
    String username;


    @Type(type = "JSON")
    @Column(columnDefinition = "JSON")
    List<String> books;

}
