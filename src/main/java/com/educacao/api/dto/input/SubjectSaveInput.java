package com.educacao.api.dto.input;

import java.io.Serializable;

import lombok.Data;

@Data
public class SubjectSaveInput implements Serializable {
	
	private static final long serialVersionUID = -3216690843615771570L;
	
	private String name;
}
