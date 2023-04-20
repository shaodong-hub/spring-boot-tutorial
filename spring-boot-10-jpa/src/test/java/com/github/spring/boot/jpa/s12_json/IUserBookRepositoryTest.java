package com.github.spring.boot.jpa.s12_json;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.function.Consumer;

/**
 * create in 2023/4/19 15:10
 *
 * @author shishaodong
 * @version 0.0.1
 */
@DataJpaTest
@Rollback(value = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("junit")
class IUserBookRepositoryTest {

    @Resource
    IUserBookRepository repository;

    @BeforeEach
    void beforeEach(){
        repository.save(UserS12Entity.builder().id(1L).username("name_1").books(List.of("data_11", "data_12")).build());
        repository.save(UserS12Entity.builder().id(2L).username("name_2").books(List.of("data_21", "data_22")).build());
        repository.save(UserS12Entity.builder().id(3L).username("name_3").books(List.of("data_31", "data_32")).build());
    }

    @Test
    void findAllByData() {
        List<UserS12Entity> data = repository.findAllByData("data_11");
        data.forEach(System.out::println);
    }

    @Test
    void find() {
//        repository.find().forEach(System.out::println);
    }
}