package com.github.spring.boot.jpa.s02_converter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * create in 2022/12/21 15:57
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Setter
@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ContactsRecord implements Serializable {

    private String firstname;

    private String lastname;

}
