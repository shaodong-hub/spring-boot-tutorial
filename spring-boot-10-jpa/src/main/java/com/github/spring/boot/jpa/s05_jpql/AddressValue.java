package com.github.spring.boot.jpa.s05_jpql;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * create in 2023/1/4 17:19
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Data
@Slf4j
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressValue implements Serializable {

    private static final long serialVersionUID = 8330351916838251803L;

    private String name;

    private String path;
}
