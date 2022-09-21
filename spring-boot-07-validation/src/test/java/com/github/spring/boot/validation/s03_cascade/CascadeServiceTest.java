package com.github.spring.boot.validation.s03_cascade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * create in 2022/8/6 16:52
 *
 * @author shishaodong
 * @version 0.0.1
 */
@DisplayName("级联校验")
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CascadeServiceTest {

    @Resource
    private CascadeService cascadeService;

    @DisplayName("对分组 1 进行校验")
    @Nested
    class Cascade {

        @Order(1)
        @Test
        @DisplayName("参数都正常")
        void check1() {
            UserInfoCommand cascade = cascadeService.cascade(command1());
            Assertions.assertEquals(20, cascade.getAge());
        }

        @Order(2)
        @Test
        @DisplayName("UserExt Email 不符合格式")
        void check2() {
            Assertions.assertThrowsExactly(ConstraintViolationException.class, () -> cascadeService.cascade(command2()));
        }

        @Order(3)
        @Test
        @DisplayName("map Future 不符合格式")
        void check3() {
            Assertions.assertThrowsExactly(ConstraintViolationException.class, () -> cascadeService.cascade(command3()));
        }

    }

    private UserInfoCommand command1() {
        UserInfoCommand userInfoCommand = new UserInfoCommand();
        userInfoCommand.setAge(20);
        Map<Integer, BookInfo> bookMaps = new HashMap<>();
        bookMaps.put(1, new BookInfo("the bad",
                LocalDate.now().plusDays(1)));
        userInfoCommand.setBookMaps(bookMaps);
        userInfoCommand.setUserExt(new UserExt("123456", "spring@qq.com"));
        return userInfoCommand;
    }

    private UserInfoCommand command2() {
        UserInfoCommand userInfoCommand = new UserInfoCommand();
        userInfoCommand.setAge(20);
        Map<Integer, BookInfo> bookMaps = new HashMap<>();
        bookMaps.put(1, new BookInfo("the bad",
                LocalDate.now().plusDays(1)));
        userInfoCommand.setBookMaps(bookMaps);
        userInfoCommand.setUserExt(
                new UserExt("123456", "spring.qq.com"));
        return userInfoCommand;
    }

    private UserInfoCommand command3() {
        UserInfoCommand userInfoCommand = new UserInfoCommand();
        userInfoCommand.setAge(20);
        Map<Integer, BookInfo> bookMaps = new HashMap<>();
        bookMaps.put(1,
                new BookInfo("the bad",
                        LocalDate.now().minusDays(1)));
        userInfoCommand.setBookMaps(bookMaps);
        userInfoCommand.setUserExt(
                new UserExt("123456", "spring@qq.com"));
        return userInfoCommand;
    }
}