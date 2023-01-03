package com.github.spring.boot.jpa.s02_converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * create in 2023/1/3 21:24
 *
 * @author shishaodong
 * @version 0.0.1
 */
@ActiveProfiles("junit")
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("埋点接口测试")
class UserFacadeTest {

    @Resource
    private MockMvc mvc;

    @Test
    @Sql("classpath:db/S02.sql")
    void findById() throws Exception {
        mvc.perform(get("/1").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.contacts.firstname").value("firstname1"))
                .andExpect(jsonPath("$.contacts.lastname").value("lastname1"))
                .andExpect(jsonPath("$.identity").value("123"))
        ;
    }
}