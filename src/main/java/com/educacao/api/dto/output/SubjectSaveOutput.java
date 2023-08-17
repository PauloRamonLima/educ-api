package com.educacao.api.dto.output;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectSaveOutput implements Serializable {
	
	private static final long serialVersionUID = -548454242732958342L;
	
	private Long id;
	private String name;
}
