package com.educacao.api.domain.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educacao.api.domain.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{ 
	Page<Student> findByNameContainingIgnoreCase(String name, Pageable pageable);
	Page<Student> findByRegistration(String registration, Pageable pageable);
}