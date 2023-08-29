package com.educacao.api.dto.output;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherListOutput implements Serializable {
	
	private static final long serialVersionUID = 7417496345340096330L;

	private Long id;
	private String name;
	private String cpf;
	private String phoneNumber;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate bornDate;
}
