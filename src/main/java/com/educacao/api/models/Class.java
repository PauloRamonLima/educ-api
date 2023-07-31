package com.educacao.api.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_class")
@Getter
@Setter
public class Class {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_class_subject", joinColumns = {@JoinColumn(name = "id_class", referencedColumnName = "id")}, inverseJoinColumns = { @JoinColumn(name = "id_subject", referencedColumnName = "id")})
	private List<Subject> listSubject;
	
	@OneToMany(mappedBy = "studentClass")
	private List<Student> listStudent;
}
