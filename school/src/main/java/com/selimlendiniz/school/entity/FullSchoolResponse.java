package com.selimlendiniz.school.entity;

import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullSchoolResponse {

    private String name;

    private String email;

    List<Student> students;
}
