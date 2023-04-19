package com.github.spring.boot.jpa.s02_converter.converter;

import org.springframework.stereotype.Component;

/**
 * create in 2023/1/12 20:29
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Component
public class PasswordProviderImpl implements IPasswordProvider {
    @Override
    public String getPassword() {
        return "---------------------";
    }
}
