package com.educacao.api.domain.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
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
public class Question implements Serializable {
	
	private static final long serialVersionUID = -4887044840296192619L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	private List<Alternative> listAlternatives;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_test", referencedColumnName = "id", nullable = false)
	private Test test;

}