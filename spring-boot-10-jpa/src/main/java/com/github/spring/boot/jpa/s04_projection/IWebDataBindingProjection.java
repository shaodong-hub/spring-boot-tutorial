package com.github.spring.boot.jpa.s04_projection;

import org.springframework.data.web.JsonPath;
import org.springframework.data.web.ProjectedPayload;

/**
 * create in 2023/1/4 01:21
 *
 * @author shishaodong
 * @version 0.0.1
 */
@ProjectedPayload
public interface IWebDataBindingProjection {

    @JsonPath("$.firstname")
    String getFirstname();

    @JsonPath("$.lastname")
    String getLastname();
}
