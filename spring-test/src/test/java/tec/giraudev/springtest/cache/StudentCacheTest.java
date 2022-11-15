package tec.giraudev.springtest.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import tec.giraudev.springtest.domain.Student;
import tec.giraudev.springtest.repository.StudentRepository;
import tec.giraudev.springtest.service.StudentNotFoundException;
import tec.giraudev.springtest.service.StudentService;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class StudentCacheTest {

    @Autowired
    private StudentService studentService;

    //we want to simulate this service
    @MockBean
    private StudentRepository studentRepository;

    @Test
    void getStudentByIdForMultipleRequestsIsRetrievedFromCache() throws StudentNotFoundException {

        //given
        Long id = 123L;
        given(studentRepository.findById(id)).willReturn(Optional.of(new Student(id, "Mark")));

        //when
        studentService.getStudentById(id);
        studentService.getStudentById(id);
        studentService.getStudentById(id);

        //then
        then(studentRepository).should(times(1)).findById(id);

    }
}
