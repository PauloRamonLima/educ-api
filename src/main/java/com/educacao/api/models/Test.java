package com.educacao.api.models;

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
@Table(name = "tb_test")
@Getter
@Setter
public class Test {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
	private List<Question> listQuestion;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_class", referencedColumnName = "id", nullable = false)
	private Class testClass;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subject", referencedColumnName = "id", nullable = false)
	private Subject subject;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_teacher", referencedColumnName = "id", nullable = false)
	private Teacher teacher;
	
}
