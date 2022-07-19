package com.github.spring.boot.jackson.infrastructure.common;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * create in 2022/7/18 00:01
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Getter
@Setter
public class UserInfo {

    @JsonProperty(value = "account")
    private String username;

    private String note;

    /**
     * DateTimeFormat 是将String转换成Date，一般前台给后台传值时用
     * JsonFormat     将Date转换成String  一般后台传值给前台时
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime dateTime;

    /**
     * 为反序列化期间要接受的属性定义一个或多个替代名称
     */
    @JsonIgnore
    @JsonAlias({"pass1", "pass2"})
    private String pass;


}
