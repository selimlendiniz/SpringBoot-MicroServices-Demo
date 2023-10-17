package com.selimlendiniz.school.service;

import com.selimlendiniz.school.client.StudentClient;
import com.selimlendiniz.school.entity.FullSchoolResponse;
import com.selimlendiniz.school.entity.School;
import com.selimlendiniz.school.repository.ISchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final ISchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public void saveSchool(School student) {
        schoolRepository.save(student);
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        var school = schoolRepository.findById(schoolId)
                .orElse(
                        School.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()
                );

        var students = studentClient.findAllStudentsBySchool(schoolId);

        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
