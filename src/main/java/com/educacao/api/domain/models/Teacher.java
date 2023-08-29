package com.educacao.api.domain.models;

import java.io.Serializable;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_teacher")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Serializable {
	
	private static final long serialVersionUID = -4667804485243966243L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String cpf;
	
	private String phoneNumber;
	
	private LocalDate bornDate;
	
	private String email;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_teacher_class", joinColumns = {@JoinColumn(name = "id_teacher", referencedColumnName = "id")}, inverseJoinColumns = { @JoinColumn(name = "id_class", referencedColumnName = "id")})
	private List<Class> listClass;
	
	public Teacher(Long id) {
		this.id = id;
	}
}
