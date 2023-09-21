package com.educacao.api.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educacao.api.domain.models.ClassTimeTable;


@Repository
public interface ClassTimeTableRepository extends JpaRepository<ClassTimeTable, Long> {
	List<ClassTimeTable> findByClassTimeTableIdOrderByDayOfWeekEnumAscTimeAsc(Long classTimeTableId);
}