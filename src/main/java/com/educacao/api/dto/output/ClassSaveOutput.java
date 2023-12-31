package com.educacao.api.dto.output;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassSaveOutput implements Serializable {
	
	private static final long serialVersionUID = 2594657760885275000L;
	
	private Long id;
	private String name;
	private String shift;
}