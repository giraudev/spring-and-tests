package tec.giraudev.springtest.controller;

import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import tec.giraudev.springtest.domain.Student;
import tec.giraudev.springtest.service.StudentService;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class StudentControllerBaseClassTest {

    @MockBean
    private StudentService studentService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void before() throws Exception {

        RestAssuredMockMvc.mockMvc(mockMvc);
        //given
        given(studentService.getStudentById(anyLong()))
                .willReturn(Student.builder().id(1L).grade(90).name("Bob").active(true).build());

        //when//then
        mockMvc.perform(get("/students/1")).andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1L))
                .andExpect(jsonPath("name").value("Bob"))
                .andExpect(jsonPath("grade").value(90));
    }


}
