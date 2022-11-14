package tec.giraudev.springtest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tec.giraudev.springtest.domain.Student;
import tec.giraudev.springtest.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Cacheable("students")
    public Student getStudentById(Long id) throws StudentNotFoundException {
        //return studentRepository.findById(id).orElse(null);
        return studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException());
    }
}
