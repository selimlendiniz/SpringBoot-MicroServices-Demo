package com.selimlendiniz.school.client;

import com.selimlendiniz.school.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service",url = "${application.config.students-url}")
public interface StudentClient {

    @GetMapping("/school/{schoolId}")
    List<Student> findAllStudentsBySchool(@PathVariable Integer schoolId);
}
