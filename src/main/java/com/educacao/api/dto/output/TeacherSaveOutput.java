package com.educacao.api.dto.output;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherSaveOutput implements Serializable {
	
	private static final long serialVersionUID = -8803884102550569622L;
	
	private Long id;
	private String name;
	private String cpf;
	private String phoneNumber;
	private LocalDate bornDate;
}
