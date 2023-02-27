package com.github.spring.boot.jpa.s08_one_to_many;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * create in 2023/2/20 17:21
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class UserS08Facade {

    @GetMapping("/s08/{id}")
    public UserS08Entity findById(@PathVariable("id") Optional<UserS08Entity> entity) {
        return entity.orElse(null);
    }
}
