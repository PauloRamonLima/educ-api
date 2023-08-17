package com.educacao.api.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactSaveInput {
	
	private String name;
	private String phone;
	private String email;
}
