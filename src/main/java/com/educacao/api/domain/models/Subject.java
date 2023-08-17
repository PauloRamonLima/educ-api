package com.educacao.api.domain.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_subject")
@Getter
@Setter
@NoArgsConstructor
public class Subject implements Serializable {
	
	private static final long serialVersionUID = -674109727472636869L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	public Subject(String name) {
		this.name = name;
	}
	
	public Subject(Long id) {
		this.id = id;
	}
}
