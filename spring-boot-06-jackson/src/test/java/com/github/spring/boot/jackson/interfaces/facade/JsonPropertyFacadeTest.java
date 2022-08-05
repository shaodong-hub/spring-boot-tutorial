package com.github.spring.boot.jackson.interfaces.facade;

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
 * create in 2022/7/18 00:12
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("测试别名")
class JsonPropertyFacadeTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    @DisplayName("代码中使用 username, 传参时使用 account")
    void jsonProperty() throws Exception {
        mockMvc.perform(post("/JsonProperty")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getData()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.account").value("test_username"))
                .andExpect(jsonPath("$.note").value("测试"))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    private String getData() {
        return "{\n" +
                "  \"account\" : \"test_username\",\n" +
                "  \"note\": \"测试\"" +
                "}";
    }

}