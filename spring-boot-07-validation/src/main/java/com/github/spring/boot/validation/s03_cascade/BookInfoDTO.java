package com.github.spring.boot.validation.s03_cascade;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Future;
import java.util.Date;

/**
 * create in 2021/5/14 9:23 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookInfoDTO {

    @Length(min = 4, max = 10)
    String bookName;

    @Future
    Date expireDate;


}
