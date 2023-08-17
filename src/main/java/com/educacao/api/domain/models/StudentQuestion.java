package com.educacao.api.domain.models;

import java.io.Serializable;

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
@Table(name = "tb_student_question")
@Getter
@Setter
public class StudentQuestion implements Serializable {
	
	private static final long serialVersionUID = 3897574999928578854L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_question", referencedColumnName = "id", nullable = false)
	private Question question;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alternative_chosen", referencedColumnName = "id", nullable = false)
	private Alternative alternativeChosen;
	
	private Boolean correct;
}
