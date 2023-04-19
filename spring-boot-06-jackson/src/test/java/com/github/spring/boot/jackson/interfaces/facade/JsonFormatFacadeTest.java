package com.github.spring.boot.jackson.interfaces.facade;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
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
 * create in 2022/7/31 23:32
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("前后端传时间")
class JsonFormatFacadeTest {

    @Resource
    protected MockMvc mockMvc;

    @Test
    @DisplayName("时间格式为 yyyy-MM-dd")
    void jsonFormat() throws Exception {
        String contentAsString = mockMvc.perform(post("/JsonFormat")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getData()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("test_username"))
                .andExpect(jsonPath("$.timestamp").value("2022-08-01"))
                .andExpect(jsonPath("$.dateString").value("2022-08-01"))
                .andExpect(jsonPath("$.dateTime").value("2022-02-02"))
                .andReturn().getResponse().getContentAsString();
        log.info(contentAsString);
    }

    protected String getData() {
        return "{\n" +
                "  \"username\" : \"test_username\",\n" +
                "  \"timestamp\" : 1659337261000,\n" +
                "  \"dateString\" : \"2022-08-01 15:01:01\",\n" +
                "  \"dateTime\": \"2022-02-02\"" +
                "}";
    }

}