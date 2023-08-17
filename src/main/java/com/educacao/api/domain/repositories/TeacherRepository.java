package com.educacao.api.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educacao.api.domain.models.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}