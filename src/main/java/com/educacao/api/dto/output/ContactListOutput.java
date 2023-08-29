package com.educacao.api.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactListOutput {
	private String name;
	private String phone;
	private String email;
}
