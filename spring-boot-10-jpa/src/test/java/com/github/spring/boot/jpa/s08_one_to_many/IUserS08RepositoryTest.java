package com.github.spring.boot.jpa.s08_one_to_many;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * create in 2022/12/14 13:06
 *
 * @author shishaodong
 * @version 0.0.1
 */
@ActiveProfiles("junit")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IUserS08RepositoryTest {

    @Resource
    private IUserS08Repository repository;

//    @AfterEach
//    void afterEach() {
//        repository.deleteAll();
//    }

    @Test
    @Sql(scripts = "classpath:db/S08.sql")
    @SqlMergeMode(SqlMergeMode.MergeMode.OVERRIDE)
    void findById() {
        Optional<UserS08Entity> optional = repository.findById(1L);
        optional.ifPresent(this::extracted);
    }

    @Test
    @Rollback(value = false)
    void save() {
        repository.deleteAll();
        UserS08Entity entity = UserS08Entity.builder().username("junit_username_1")
//                .banners(Collections.singletonList(ImageS08Entity.builder().name("image-1").type(1).status(1).build()))
//                .icons(Collections.singletonList(ImageS08Entity.builder().name("image-2").type(2).status(1).build()))
                .build();
        repository.save(entity);
    }


    @Test
    @Sql(scripts = "classpath:db/S08-2.sql")
    @SqlMergeMode(SqlMergeMode.MergeMode.OVERRIDE)
    @Rollback(value = false)
    void update() {
        Optional<UserS08Entity> optional = repository.findById(1L);
        Assertions.assertTrue(optional.isPresent());
        UserS08Entity s08Entity = optional.get();
        s08Entity.updateBanners(Collections.singletonList(ImageS08Entity.builder().name("image-2").type(1).status(1).build()));
//        s08Entity.updateIcons(Collections.singletonList(ImageS08Entity.builder().name("image-3").type(2).status(1).build()));
        repository.save(s08Entity);
    }

    @Test
    @Sql(scripts = "classpath:db/S08-2.sql")
    @SqlMergeMode(SqlMergeMode.MergeMode.OVERRIDE)
    @Rollback(value = false)
    void findByBannersContains() {
        List<UserS08Entity> list = repository.findByBannersContains();
        list.forEach(System.out::println);
    }

    @Test
    @Sql(scripts = "classpath:db/S08-2.sql")
    @SqlMergeMode(SqlMergeMode.MergeMode.OVERRIDE)
    @Rollback(value = false)
    void findByBannersContains2() {
        List<UserS08VO> list = repository.findByBannersByImages();
        list.forEach(x -> System.out.println(x.getId()));
    }

    @Test
    @Sql(scripts = "classpath:db/S08-2.sql")
    @SqlMergeMode(SqlMergeMode.MergeMode.OVERRIDE)
    @Rollback(value = false)
    void findImage() {
        Optional<ImageS08Entity> optional = repository.findImage();
        optional.ifPresent(System.out::println);
    }


    @SneakyThrows
    private void extracted(UserS08Entity users08Entity) {
        System.out.println("----------- " + new ObjectMapper().writeValueAsString(users08Entity));
    }

    interface User08VO {
        Long getId();
    }
}