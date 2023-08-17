package com.educacao.api.dto.output;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentListOutput implements Serializable {
	
	private static final long serialVersionUID = 2016579870107608260L;
	
	private Long id;
	private String registration;
	private String name;
	private LocalDate bornDate;
	private String phoneNumber;
	private String studentClassName;
	private String studentClassShift;
}
