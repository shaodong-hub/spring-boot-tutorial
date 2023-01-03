package com.github.spring.boot.validation.s08_controller;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * create in 2022/8/6 16:15
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@RestController
public class ValidateController {

    @GetMapping("/path/{data}")
    public String checkPath(@PathVariable @Length(min = 5, max = 10) String data) {
        return data;
    }

    @PostMapping("data")
    public UserCreateCommand check(@Valid @RequestBody UserCreateCommand command, BindingResult result) {
        if (result.hasErrors()) {
            result.getAllErrors().forEach(objectError -> log.info(objectError.toString()));
        }
        return command;
    }
}
