package com.educacao.api.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_question")
@Getter
@Setter
public class Question {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "question")
	private List<Alternative> listAlternatives;
	
	private Alternative alternativeChosen;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_test", referencedColumnName = "id", nullable = false)
	private Test test;

}
