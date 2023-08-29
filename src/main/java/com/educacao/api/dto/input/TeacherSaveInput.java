package com.educacao.api.dto.input;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherSaveInput implements Serializable {
	
	private static final long serialVersionUID = 8022176019634681280L;
	
	private Long id;
	private String name;
	private String cpf;
	private String phoneNumber;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate bornDate;
}
