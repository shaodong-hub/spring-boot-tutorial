package com.github.spring.boot.jackson.infrastructure.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

/**
 * create in 2022/7/31 22:35
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Data
public class UserInfoJsonFormat {

    private String username;

    /**
     * private Date dateTime
     * <p>
     * DateTimeFormat 是将String转换成Date，一般前台给后台传值时用
     * JsonFormat     将Date转换成String  一般后台传值给前台时
     * {@link LocalDateSerializer}需要新增这个序列化器
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private LocalDate dateTime;

    /**
     * 以字符串形式接收 yyyy-MM-dd HH:mm:ss ,以字符串形式返回 yyyy-MM-dd
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date dateString;

    /**
     * 以时间戳形式接收,以字符串形式返回 yyyy-MM-dd
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date timestamp;

}
