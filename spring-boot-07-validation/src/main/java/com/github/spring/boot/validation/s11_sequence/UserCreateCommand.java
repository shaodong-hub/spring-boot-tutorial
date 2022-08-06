package com.github.spring.boot.validation.s11_sequence;

import com.github.spring.boot.validation.s11_sequence.annotation.CustomOrder1;
import com.github.spring.boot.validation.s11_sequence.annotation.CustomOrder2;
import com.github.spring.boot.validation.s11_sequence.annotation.CustomOrder3;
import com.github.spring.boot.validation.s11_sequence.order.Order1;
import com.github.spring.boot.validation.s11_sequence.order.Order2;
import com.github.spring.boot.validation.s11_sequence.order.Order3;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.validation.GroupSequence;

/**
 * create in 2021/5/13 7:31 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@GroupSequence({Order3.class, Order2.class, Order1.class, UserCreateCommand.class})
public class UserCreateCommand {

    @CustomOrder1(groups = Order1.class)
    @CustomOrder2(groups = Order2.class)
    @CustomOrder3(groups = Order3.class)
    String username;

}



