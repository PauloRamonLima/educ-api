package com.educacao.api.dto.output;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassStudentsListOutput implements Serializable {
	
	private static final long serialVersionUID = 5388853638979849492L;
	
	private String name;
	private String registration;

}
