package com.github.spring.boot.jpa.s11_annotation.parent;

import lombok.AccessLevel;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * create in 2023/4/13 23:17
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "s11_parent")
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT COMMENT 'id'")
    Long id;

    Name name;
}
