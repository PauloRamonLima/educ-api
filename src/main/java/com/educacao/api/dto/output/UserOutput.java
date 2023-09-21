package com.educacao.api.dto.output;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOutput implements Serializable {
	
	private static final long serialVersionUID = -15656643753983669L;
	
	private Long id;
	private String name;
	private String email;
	private String phoneNumber;
	private String cpf;
}