package com.educacao.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_student_test")
@Getter
@Setter
public class StudentTest {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_student", referencedColumnName = "id", nullable = false)
	private Student student;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_test", referencedColumnName = "id", nullable = false)
	private Test test;
	
	private Integer grade;
	
	private Boolean aproved;
}
