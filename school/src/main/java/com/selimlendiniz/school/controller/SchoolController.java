package com.selimlendiniz.school.controller;

import com.selimlendiniz.school.entity.FullSchoolResponse;
import com.selimlendiniz.school.entity.School;
import com.selimlendiniz.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(
            @RequestBody School school
    ) {
        schoolService.saveSchool(school);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<School>> getAllStudents() {
        return new ResponseEntity<>(schoolService.getAllSchools(), HttpStatus.OK);
    }

    @GetMapping("/with-students/{schoolId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<FullSchoolResponse> findAllSchools(
            @PathVariable Integer schoolId
    ) {
        return new ResponseEntity<>(schoolService.findSchoolsWithStudents(schoolId), HttpStatus.OK);
    }


}
