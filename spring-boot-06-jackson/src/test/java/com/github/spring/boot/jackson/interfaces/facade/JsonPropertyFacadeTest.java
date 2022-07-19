package com.github.spring.boot.jackson.interfaces.facade;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
class JsonPropertyFacadeTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    void userInfoGet() throws Exception {
        mockMvc.perform(get("/json-property").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.account").value("test_username"))
                .andReturn()
                .getResponse()
                .getContentAsString();

    }

    @Test
    void userInfoPost() throws Exception {
        mockMvc.perform(post("/json-property").content(getData())
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.account").value("test_username"))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }


    private String getData() {
        return "{\n" +
                "  \"account\" : \"test_username\",\n" +
                "  \"note\": \"测试\",\n" +
                "  \"dateTime\": \"2000-11-11\"\n" +
                "}";
    }


}