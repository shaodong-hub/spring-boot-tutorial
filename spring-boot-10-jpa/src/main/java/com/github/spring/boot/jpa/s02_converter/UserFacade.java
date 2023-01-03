package com.github.spring.boot.jpa.s02_converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * create in 2023/1/3 21:22
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@RestController
public class UserFacade {


    @GetMapping("/{id}")
    public UserS02Entity findById(@PathVariable("id") Optional<UserS02Entity> entity) {
        return entity.get();
    }

}
