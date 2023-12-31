package com.educacao.api.dto.output;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestSaveOutput implements Serializable {
	
	private static final long serialVersionUID = 7713984312520782420L;
	
	private Long id;
	private String description;

}
