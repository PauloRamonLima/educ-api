package com.educacao.api.domain.models;

import java.io.Serializable;
import java.util.ArrayList;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_class")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Class implements Serializable {
	
	private static final long serialVersionUID = -6342711372822678371L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String shift;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_class_subject", joinColumns = {@JoinColumn(name = "id_class", referencedColumnName = "id")}, inverseJoinColumns = { @JoinColumn(name = "id_subject", referencedColumnName = "id")})
	private List<Subject> listSubject;
	
	@OneToMany(mappedBy = "studentClass")
	private List<Student> listStudent;

	public Class(Long id) {
		this.id = id;
	}
	
	public void addStudent(Student student) {
		if(listStudent == null)
			listStudent = new ArrayList<>();
		listStudent.add(student);
	}
	
	public void addSubject(Subject subject) {
		if(listSubject == null)
			listSubject = new ArrayList<>();
		listSubject.add(subject);
	}
}