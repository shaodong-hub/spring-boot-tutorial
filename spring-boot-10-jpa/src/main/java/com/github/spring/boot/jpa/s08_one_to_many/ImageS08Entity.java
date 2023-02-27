package com.github.spring.boot.jpa.s08_one_to_many;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * create in 2022/12/14 10:44
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Entity
@Table(name = "S08_image")
@DynamicUpdate
@DynamicInsert
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter@Setter@ToString(exclude="user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageS08Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT COMMENT 'id'")
    Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(32) COMMENT '名称'")
    String name;

    @Column(name = "type", columnDefinition = "TINYINT COMMENT '类型'")
    Integer type;

    @Column(name = "status", columnDefinition = "TINYINT COMMENT '状态'")
    Integer status;

    @Column(name = "user_id", insertable = false, updatable = false)
    Long userId;

    @ManyToOne(targetEntity = UserS08Entity.class, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference
    UserS08Entity user;

}
