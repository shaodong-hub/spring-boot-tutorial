package com.github.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * create in 2022/8/6 16:08
 *
 * @author shishaodong
 * @version 0.0.1
 */
@EnableScheduling
@EnableMongoAuditing
@SpringBootApplication
public class SpringBootMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongoApplication.class, args);
    }

}
