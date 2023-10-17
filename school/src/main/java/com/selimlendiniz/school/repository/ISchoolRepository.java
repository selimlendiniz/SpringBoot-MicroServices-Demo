package com.selimlendiniz.school.repository;

import com.selimlendiniz.school.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISchoolRepository extends JpaRepository<School, Integer> {
}
