package com.example.n11_final_case.controller;

/*
 * @author batuhanvural
 */

import com.example.n11_final_case.dto.UserDto;
import com.example.n11_final_case.entity.User;
import com.example.n11_final_case.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;



@WebMvcTest(controllers = UserControllerTest.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
//@SpringBootTest(classes ={N11FinalCaseApplication.class})
class UserControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;
    private UserDto userDto;


    @Test
    void shouldSaveUser() throws Exception {
        String requestAsString = "{\n"
                + "  \"id\": \"6\",\n"
                + "  \"name\": \"name\",\n"
                + "  \"surname\": \"surname\",\n"
                + "  \"age\": \"12\",\n"
                + "  \"latitude\": \"22\",\n"
                + "  \"longitude\": \"31\",\n"
                + "}";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/api/v1/user/create").content(requestAsString).contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println(mvcResult.toString());
    }

}
