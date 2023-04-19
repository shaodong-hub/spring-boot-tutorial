package com.github.spring.boot.jackson.interfaces.facade;

import jakarta.annotation.Resource;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * create in 2022/7/31 23:10
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("测试 json 视图")
class JsonViewFacadeTest {

    @Resource
    private MockMvc mvc;

    @Test
    @DisplayName("username, age 必须存在, note 不存在")
    void simpleView() throws Exception {
        mvc.perform(post("/SimpleView").contentType(MediaType.APPLICATION_JSON).content(getContent()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.username").value("test_username"))
                .andExpect(jsonPath("$.age").value(18))
                .andExpect(jsonPath("$.note").doesNotExist());
    }

    @Test
    @DisplayName("username, age note 均存在")
    void detailView() throws Exception {
        mvc.perform(post("/DetailView").contentType(MediaType.APPLICATION_JSON).content(getString()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.username").value("test_username"))
                .andExpect(jsonPath("$.age").value(18))
                .andExpect(jsonPath("$.note").value("test_note"));
    }

    @NotNull
    private String getContent() {
        return "{\n" +
                "  \"username\": \"test_username\"," +
                "  \"age\": 18,\n" +
                "  \"note\": \"test_note\"\n" +
                "}";
    }

    @NotNull
    private String getString() {
        return "{\n" +
                "  \"username\": \"test_username\"," +
                "  \"age\": 18,\n" +
                "  \"note\": \"test_note\"\n" +
                "}";
    }
}