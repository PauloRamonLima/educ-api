package com.educacao.api.dto.output;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectListOutput implements Serializable {
	
	private static final long serialVersionUID = -4198787794067559055L;
	
	private Long id;
	private String name;
}