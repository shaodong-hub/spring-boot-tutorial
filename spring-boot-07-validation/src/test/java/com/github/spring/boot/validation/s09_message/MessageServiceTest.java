package com.github.spring.boot.validation.s09_message;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;
import java.time.LocalDate;

/**
 * create in 2022/8/6 17:02
 *
 * @author shishaodong
 * @version 0.0.1
 */
@DisplayName("自定义提示语")
@SpringBootTest
class MessageServiceTest {

    @Resource
    private MessageService messageService;

    @Test
    @DisplayName("查看提示语")
    void message() {
        messageService.message(new UserCreateCommand("name", LocalDate.now().plusDays(1)));
        Assertions.assertThrowsExactly(ConstraintViolationException.class, () -> messageService.message(new UserCreateCommand("name", LocalDate.now().plusDays(1))));
    }
}