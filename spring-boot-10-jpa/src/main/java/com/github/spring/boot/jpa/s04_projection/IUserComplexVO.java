package com.github.spring.boot.jpa.s04_projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * SPEL
 * <p>
 * create in 2022/12/14 20:25
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IUserComplexVO {

    Long getId();

    @Value("#{@UserService.doSomething(target.username)}")
    String getUsername();

    @SuppressWarnings("unused")
    @Component("UserService")
    class UserService {

        public String doSomething(String username) {
            return username + " do something";
        }
    }
}
