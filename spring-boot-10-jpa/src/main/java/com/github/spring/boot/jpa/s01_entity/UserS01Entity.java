package com.github.spring.boot.jpa.s01_entity;


import com.github.spring.boot.jpa.s01_entity.value.UsernameRecord;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * create in 2021/7/15 9:28 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Entity
@Table(name = "S01")
@DynamicInsert
@DynamicUpdate
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserS01Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT COMMENT 'id'")
    Long id;

    @Getter
    @Embedded
    @AttributeOverride(name = "username", column = @Column(name = "username", nullable = false, columnDefinition = "CHAR(50) COMMENT 'username'"))
    UsernameRecord username;


    @Column(name = "note", columnDefinition = "CHAR(50) COMMENT 'note'")
    String note;

    public UserS01Entity updateUsername(UsernameRecord username) {
        this.username = username;
        return this;
    }

}
