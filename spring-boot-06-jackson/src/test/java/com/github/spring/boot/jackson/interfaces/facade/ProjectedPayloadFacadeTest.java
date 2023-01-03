package com.github.spring.boot.jackson.interfaces.facade;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * create in 2022/12/20 10:34
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("测试 ProjectedPayload 视图")
class ProjectedPayloadFacadeTest {

    @Resource
    private MockMvc mvc;

    @Test
    @DisplayName("测试 ProjectedPayload 视图")
    void userPayload() throws Exception {
        mvc.perform(post("/payload").contentType(MediaType.APPLICATION_JSON).content(getContent()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.username").value("test_username"))
                .andExpect(jsonPath("$.lastname").value("test_lastname"));

    }

    @NotNull
    private static String getContent() {
        return "{\n" +
                "  \"firstname\": \"test_username\",\n" +
                "  \"lastname\": \"test_lastname\"\n" +
                "}";
    }
}