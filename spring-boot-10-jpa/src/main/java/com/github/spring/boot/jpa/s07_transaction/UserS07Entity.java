package com.github.spring.boot.jpa.s07_transaction;

import com.github.spring.boot.jpa.s03_event.UserCreateEvent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Collections;

/**
 * create in 2022/12/8 16:47
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Entity
@Table(name = "S07")
@DynamicInsert
@DynamicUpdate
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuppressWarnings("S03")
public class UserS07Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT COMMENT 'id'")
    Long id;

    @Column(name = "username", nullable = false, columnDefinition = "CHAR(100) COMMENT 'username'")
    String username;

    public void updateUsername(String username){
        this.username = username;
    }
}
