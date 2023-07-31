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
@Table(name = "tb_alternative")
@Getter
@Setter
public class Alternative {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	private Boolean correct;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_question", referencedColumnName = "id", nullable = false)
	private Question question;
}
