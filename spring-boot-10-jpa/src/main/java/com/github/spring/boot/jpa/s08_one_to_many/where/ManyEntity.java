package com.github.spring.boot.jpa.s08_one_to_many.where;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.github.spring.boot.jpa.s08_one_to_many.UserS08Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Comment;
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
 * create in 2023/4/13 20:54
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Entity
@Table(name = "s08_many")
@DynamicInsert
@DynamicUpdate
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ManyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT COMMENT 'id'")
    Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(32) COMMENT '名称'")
    String name;

    @Column(name = "type", columnDefinition = "TINYINT COMMENT '类型'")
    Integer type;

    @Column(name = "one_id", insertable = false, updatable = false)
    Long oneId;

    @ManyToOne(targetEntity = OneEntity.class, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JsonBackReference
    OneEntity user;
}
