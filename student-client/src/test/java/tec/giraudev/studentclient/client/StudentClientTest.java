package tec.giraudev.studentclient.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import tec.giraudev.studentclient.domain.Student;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest
@AutoConfigureWireMock
public class StudentClientTest {

    @Autowired
    private StudentClient studentClient;

    @Test
    void getStudentForGivenStudentIsReturned(){
        //given
        Long id = 1l;
        stubFor(get("/students/"+id).willReturn(okJson("""
                {"id":1,
                "studentName":"Bob",
                "grade":90
                }
                """)));

        //whn
        Student student = studentClient.getStudent(id);

        //then
        then(student.getId()).isNotNull();
        then(student.getStudentName()).isEqualTo("Bob");
        then(student.getGrade()).isEqualTo(90);

    }
}
