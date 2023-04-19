package com.github.spring.boot.validation.s08_controller;

import jakarta.annotation.Resource;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * create in 2022/8/6 23:19
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
@AutoConfigureMockMvc
class ValidateControllerTest {

    @Resource
    private MockMvc mvc;


    @Test
    void checkPath() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/path/123").contentType(MediaType.APPLICATION_JSON).content(getContent()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.code").value())
        ;
    }


    @Test
    void check() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/data").contentType(MediaType.APPLICATION_JSON).content(getContent()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.code").value())
        ;
    }

    @NotNull
    private String getContent() {
        return "{\"username\": \"name\",\"age\": 30}";
    }

}