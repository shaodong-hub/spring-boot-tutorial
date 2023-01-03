package com.github.spring.boot.jackson.interfaces.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.web.JsonPath;
import org.springframework.data.web.ProjectedPayload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * create in 2022/12/20 10:27
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@RestController
public class ProjectedPayloadFacade {

    @PostMapping("payload")
    public UserPayload userPayload(@RequestBody UserPayload userPayload) throws JsonProcessingException {
        log.info(new ObjectMapper().writeValueAsString(userPayload));
        return userPayload;
    }

    @ProjectedPayload
    interface UserPayload {

        @JsonPath("$.firstname")
        String getUsername();

        @JsonPath({"$.lastname", "$.user.lastname"})
        String getLastname();
    }
}
