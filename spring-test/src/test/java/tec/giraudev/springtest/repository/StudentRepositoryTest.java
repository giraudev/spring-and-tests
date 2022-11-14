package tec.giraudev.springtest.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import tec.giraudev.springtest.domain.Student;

import java.util.Optional;

import static org.assertj.core.api.BDDAssertions.then;

//we could use @SpringBootTest, but we only want to test JPA
@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void testGetStudentByNameReturnsStudentDetail(){
        //given
        //Student savedStudent = studentRepository.save(new Student(null, "Mark"));
        Student savedStudent = testEntityManager.persistAndFlush(new Student(null, "Mark"));

        //when
        Optional<Student> student = studentRepository.getStudentByName(savedStudent.getName());

        //then
        then(student.get()).isNotNull();
        then(student)
    }

    @Test
    void getAvgGradeForActiveStudentsCalculatesAvg(){
        //given

    }


}
