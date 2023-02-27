package com.github.spring.boot.jpa.s08_one_to_many;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * create in 2023/2/20 19:43
 *
 * @author shishaodong
 * @version 0.0.1
 */
@ActiveProfiles("junit")
@SpringBootTest
@AutoConfigureMockMvc
class UserS08FacadeTest {

    @Resource
    private MockMvc mvc;

    @Test
    @Sql(scripts = "classpath:db/S08.sql")
    @SqlMergeMode(SqlMergeMode.MergeMode.OVERRIDE)
    void findById() throws Exception {
        mvc.perform(get("/s08/1").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
        ;
    }
}