package com.educacao.api.dto.input;

import java.io.Serializable;

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
	
	private Long id;
	@NotBlank(message = "field name is required")
	private String name;
	@NotNull(message = "field bornDate is required")
	private String bornDate;
	private String phoneNumber;
	private ContactSaveInput contact;
	private Long idClass;
}