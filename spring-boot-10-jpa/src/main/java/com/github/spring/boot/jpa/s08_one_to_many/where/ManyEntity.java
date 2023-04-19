package com.github.spring.boot.jpa.s08_one_to_many.where;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
