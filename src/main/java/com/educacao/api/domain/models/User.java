package com.educacao.api.domain.models;

import java.io.Serializable;

import com.educacao.api.domain.models.enums.UserType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
public class User implements Serializable {
	
	private static final long serialVersionUID = 7311496669252968381L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String login;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private UserType userType;
}