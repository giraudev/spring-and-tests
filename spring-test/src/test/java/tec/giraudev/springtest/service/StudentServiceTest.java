package tec.giraudev.springtest.service;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tec.giraudev.springtest.domain.Student;
import tec.giraudev.springtest.repository.StudentRepository;

import javax.transaction.Transactional;

import static org.assertj.core.api.BDDAssertions.catchThrowable;
import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class StudentServiceTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @DisplayName("Returning saved student from service layer")
    @Test
    void getStudentByIdForSavedStudentIsReturned() throws StudentNotFoundException {

        //given
        Student savedStudent = studentRepository.saveAndFlush(new Student(null, "Mark"));

        //when
        Student student = studentService.getStudentById(savedStudent.getId());

        //then
        then(student.getName()).isEqualTo("Mark");
        then(student.getId()).isNotNull();
    }

    @Test
    void getStudentByIdWhenMissingStudentNotFoundExceptionThrown(){
        //given
        Long id = 1234L;

        //when
        Throwable throwable = catchThrowable(()->studentService.getStudentById(id));

        //then
        BDDAssertions.then(throwable).isInstanceOf(StudentNotFoundException.class);
    }
}
