package com.educacao.api.dto.input;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSaveInput implements Serializable {
	
	private static final long serialVersionUID = -7132346953360796293L;
	
	@NotBlank(message = "field name is required")
	private String name;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "field bornDate is required")
	private LocalDate bornDate;
	private String phoneNumber;
	private ContactSaveInput contact;
	private Long idClass;
}
