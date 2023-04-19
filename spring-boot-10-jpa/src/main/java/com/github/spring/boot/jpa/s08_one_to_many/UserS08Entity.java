package com.github.spring.boot.jpa.s08_one_to_many;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKey;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * create in 2022/12/14 10:43
 *
 * @author shishaodong
 * @version 0.0.1
 */


@Entity
@Table(name = "S08")
@DynamicInsert
@DynamicUpdate
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserS08Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT COMMENT 'id'")
    Long id;

    @Column(name = "username", columnDefinition = "VARCHAR(32) COMMENT '姓名'")
    String username;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    @MapKey(name = "name")
    @JsonManagedReference
    Map<String, ImageS08Entity> banners;

    public void updateBanners(List<ImageS08Entity> images) {
        if (CollectionUtils.isEmpty(banners)) {
            this.banners = images.stream().collect(Collectors.toMap(ImageS08Entity::getName, x -> x));
        } else {
            banners.clear();
            banners.putAll(images.stream().collect(Collectors.toMap(ImageS08Entity::getName, x -> x)));
        }
    }
}



