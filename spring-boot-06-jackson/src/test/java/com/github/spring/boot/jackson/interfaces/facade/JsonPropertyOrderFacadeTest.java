package com.github.spring.boot.jackson.interfaces.facade;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * create in 2022/8/1 10:44
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("测试序列化字段顺序")
class JsonPropertyOrderFacadeTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    @DisplayName("序列化好的字段以字母顺序生成")
    void jsonPropertyOrder() throws Exception {
        mockMvc.perform(post("/JsonPropertyOrder").contentType(MediaType.APPLICATION_JSON).content(getData()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("test_username"))
                .andExpect(jsonPath("$.age").value(18))
                .andExpect(jsonPath("$.note").value("测试"))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    private String getData() {
        return "{\n" +
                "  \"username\" : \"test_username\",\n" +
                "  \"age\" : 18,\n" +
                "  \"note\": \"测试\"" +
                "}";
    }
}