package com.github.spring.boot.jpa.s08_one_to_many;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.CollectionUtils;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

//    @Where(clause = "type = 1")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    @MapKey(name = "name")
    @JsonManagedReference
    Map<String, ImageS08Entity> banners;

//    @Where(clause = "type = 2")
//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "user_id")
//    @JsonManagedReference
//    List<ImageS08Entity> icons;

//    public void updateIcons(@NotNull List<ImageS08Entity> images) {
//        if (CollectionUtils.isEmpty(icons)) {
//            this.icons = images;
//        } else {
//            this.icons.clear();
//            this.icons.addAll(images);
//        }
//    }

    public void updateBanners(List<ImageS08Entity> images) {
        if (CollectionUtils.isEmpty(banners)) {
            this.banners = images.stream().collect(Collectors.toMap(ImageS08Entity::getName, x -> x));
        } else {
            banners.clear();
            banners.putAll(images.stream().collect(Collectors.toMap(ImageS08Entity::getName, x -> x)));
        }
    }
}



