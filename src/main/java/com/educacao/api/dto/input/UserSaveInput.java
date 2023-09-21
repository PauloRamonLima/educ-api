package com.educacao.api.dto.input;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveInput implements Serializable {
	
	private static final long serialVersionUID = -198860352118835136L;
	
	private Long id;
	private String email;
	private String name;
	private String phoneNumber;
	private String cpf;
}
