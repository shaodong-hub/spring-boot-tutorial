package com.github.spring.boot.jpa.s04_projection;

import cn.hutool.core.io.IoUtil;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * create in 2023/1/4 01:23
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
@ActiveProfiles("junit")
@AutoConfigureMockMvc
class User04FacadeTest {

    @Resource
    MockMvc mvc;

    @Value("classpath:json/s04.json")
    org.springframework.core.io.Resource data;

    @Test
    void projection() throws Exception {
        mvc.perform(post("/user04")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(IoUtil.read(data.getInputStream(), StandardCharsets.UTF_8)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstname").value("firstname_1"))
                .andExpect(jsonPath("$.lastname").value("lastname_1"))
        ;
    }
}