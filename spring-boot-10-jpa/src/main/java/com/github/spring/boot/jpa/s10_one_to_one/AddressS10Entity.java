package com.github.spring.boot.jpa.s10_one_to_one;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * create in 2022/12/14 10:44
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Entity
@Table(name = "S10_address")
@DynamicUpdate
@DynamicInsert
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressS10Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT COMMENT 'id'")
    Long id;

    @Column(name = "city", columnDefinition = "VARCHAR(32) COMMENT '名称'")
    String city;

    @Column(name = "code", columnDefinition = "VARCHAR(32) COMMENT '类型'")
    String code;

    @OneToOne(targetEntity = UserS10Entity.class, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    @NotFound(action = NotFoundAction.IGNORE)
    UserS10Entity user;
}
