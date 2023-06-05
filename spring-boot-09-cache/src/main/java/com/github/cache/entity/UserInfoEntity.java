package com.github.cache.entity;

import com.github.cache.common.UserInfoUpdateCommand;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * create in 2023/5/31 15:27
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Entity
@Table(
        name = "user_detail",
        uniqueConstraints = {@UniqueConstraint(name = "UK_USERNAME", columnNames = {"username"})},
        indexes = {@Index(name = "IDX_PHONE", columnList = "phone")}
)
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@NoArgsConstructor
public class UserInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(nullable = false)
    private String phone;

    public UserInfoEntity(String username, String phone) {
        this.username = username;
        this.phone = phone;
    }

    public UserInfoEntity update(@NotNull UserInfoUpdateCommand command){
        this.username = command.username();
        this.phone = command.phone();
        return this;
    }
}
