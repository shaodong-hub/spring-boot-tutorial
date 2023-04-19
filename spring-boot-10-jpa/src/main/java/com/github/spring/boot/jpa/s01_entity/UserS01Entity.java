package com.github.spring.boot.jpa.s01_entity;


import com.github.spring.boot.jpa.s01_entity.value.UsernameRecord;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * <p>
 * create in 2021/7/15 9:28 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Entity
@Table(name = "S01",
        indexes = {@Index(name = "IDX_NOTE", columnList = "note")},
        uniqueConstraints = {@UniqueConstraint(name = "UK_USERNAME", columnNames = {"username"})}
)
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
