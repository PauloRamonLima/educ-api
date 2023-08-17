package com.educacao.api.dto.input;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClassSaveInput implements Serializable {
	
	private static final long serialVersionUID = 7942542538520575689L;
	
	private String name;
	private String shift;
}
