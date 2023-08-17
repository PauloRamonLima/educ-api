package com.educacao.api.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educacao.api.domain.models.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
