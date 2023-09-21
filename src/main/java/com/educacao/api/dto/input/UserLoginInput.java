package com.educacao.api.dto.input;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginInput implements Serializable {
	
	private static final long serialVersionUID = 8797333391057548429L;
	
	private String email;
	private String password;
}