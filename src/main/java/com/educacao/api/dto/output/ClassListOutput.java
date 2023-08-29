package com.educacao.api.dto.output;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassListOutput implements Serializable {
	
	private static final long serialVersionUID = -3374967383856834776L;
	
	private Long id;
	private String name;
	private String shift;

}
