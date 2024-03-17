package com.example.n11_final_case.controller;

/*
 * @author batuhanvural
 */

import com.example.n11_final_case.N11FinalCaseApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes ={N11FinalCaseApplication.class})
public class CommentControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Test
    void shouldSaveComment() throws Exception {
        String requestAsString = "{\n"
                + "  \"id\": \"6\",\n"
                + "  \"comment\": \"comment\",\n"
                + "  \"description\": \"description\",\n"
                + "}";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("api/v1/comment/create").content(requestAsString).contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println(mvcResult.toString());
    }

}
