package tec.giraudev.springtest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tec.giraudev.springtest.domain.Student;
import tec.giraudev.springtest.service.StudentNotFoundException;
import tec.giraudev.springtest.service.StudentService;

@RestController
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private final StudentService studentService;

    @PostMapping("/students/{id}")
    Student createStudent(@Validated @RequestBody Student student) {
        return studentService.create(student);
    }

    @GetMapping("/students/{id}")
    Student getStudent(@PathVariable Long id) {
        studentService.get(id);
        return studentService.getStudentById(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void notFound (StudentNotFoundException exception) {

    }
}
