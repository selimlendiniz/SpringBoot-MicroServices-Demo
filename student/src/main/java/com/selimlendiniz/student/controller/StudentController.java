package com.selimlendiniz.student.controller;

import com.selimlendiniz.student.entity.Student;
import com.selimlendiniz.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(
            @RequestBody Student student
    ) {
        studentService.saveStudent(student);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.findAllStudents(), HttpStatus.OK);
    }


    @GetMapping("/school/{schoolId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Student>> getAllStudents(
            @PathVariable Integer schoolId
            ) {
        return new ResponseEntity<>(studentService.findAllStudentsBySchool(schoolId), HttpStatus.OK);
    }


}
