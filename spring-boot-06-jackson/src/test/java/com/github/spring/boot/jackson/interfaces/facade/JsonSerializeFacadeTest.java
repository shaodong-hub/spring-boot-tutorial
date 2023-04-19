package com.github.spring.boot.jackson.interfaces.facade;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * create in 2022/8/1 10:08
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("自定义序列化与反序列化")
class JsonSerializeFacadeTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    @DisplayName("将字符串中;转换成|返回")
    void jsonSerialize() throws Exception {
        mockMvc.perform(post("/JsonSerialize").contentType(MediaType.APPLICATION_JSON).content(getData()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("test_username"))
                .andExpect(jsonPath("$.mobiles").value("111|222|333"))
                .andReturn()
                .getResponse()
                .getContentAsString();

    }

    private String getData() {
        return "{\n" +
                "  \"username\" : \"test_username\",\n" +
                "  \"mobiles\": \"111;222;333\"" +
                "}";
    }
}