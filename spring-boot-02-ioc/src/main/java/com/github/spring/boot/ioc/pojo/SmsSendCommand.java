package com.github.spring.boot.ioc.pojo;

import lombok.Data;

/**
 * create in 2022/7/11 21:35
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Data
public class SmsSendCommand {

    private String type;

    private String mobile;

    private String message;

}
