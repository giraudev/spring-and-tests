package tec.giraudev.springtest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import tec.giraudev.springtest.domain.Student;
import tec.giraudev.springtest.service.StudentNotFoundException;
import tec.giraudev.springtest.service.StudentService;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    void getStudentFrSavedStudentIsReturned() throws Exception {
        //given
        given(studentService.getStudentById(anyLong()))
                .willReturn(Student.builder().id(1L).grade(90).name("Bob").active(true).build());

        //when//then
        mockMvc.perform(get("/students/1")).andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1L))
                .andExpect(jsonPath("name").value("Bob"))
                .andExpect(jsonPath("grade").value(90));
    }

    @Test
    void getStudentForMissingStudentStatus404() throws Exception {
        //given
        given(studentService.getStudentById(anyLong())).willThrow(StudentNotFoundException.class);

        //when
        mockMvc.perform(get("/students/1")).andExpect(status().isNotFound());
    }
}
