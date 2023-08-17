package com.educacao.api.dto.output;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorMessage implements Serializable {
	
	private static final long serialVersionUID = 1511879603259658971L;
	
	private String messageError;
	
}