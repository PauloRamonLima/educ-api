package com.educacao.api.dto.input;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestSaveInput implements Serializable {
	
	private static final long serialVersionUID = -1276345610843274998L;
	
	@NotBlank(message = "field description is required")
	private String description;
	
	@NotNull(message = "field testClassId is required")
	private Long testClassId;
	
	@NotNull(message = "field subjectId is required")
	private Long subjectId;
	
	@NotNull(message = "field teacherId is required")
	private Long teacherId;
}
