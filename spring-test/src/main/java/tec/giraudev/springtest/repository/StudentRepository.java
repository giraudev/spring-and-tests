package tec.giraudev.springtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tec.giraudev.springtest.domain.Student;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> getStudentByName(String name);

    @Query("select avg (grade) from Student where active=true")
    Double getAvgGradeForActiveStudents();
}
