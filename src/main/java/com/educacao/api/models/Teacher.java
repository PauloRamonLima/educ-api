package com.educacao.api.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_teacher")
@Getter
@Setter
public class Teacher {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String cpf;
	
	private String phoneNumber;
	
	private LocalDate bornDate;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_teacher_class", joinColumns = {@JoinColumn(name = "id_teacher", referencedColumnName = "id")}, inverseJoinColumns = { @JoinColumn(name = "id_class", referencedColumnName = "id")})
	private List<Class> listClass;
}
