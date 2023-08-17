package com.educacao.api.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educacao.api.domain.models.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
