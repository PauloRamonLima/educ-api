package com.educacao.api.dto.input;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavePasswordUserInput implements Serializable {
	
	private static final long serialVersionUID = 6420209047279267302L;
	
	private String email;
	private String password;
	private String confirmPassword;
}
