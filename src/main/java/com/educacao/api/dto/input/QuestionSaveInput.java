package com.educacao.api.dto.input;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionSaveInput implements Serializable {
	
	private static final long serialVersionUID = -5101885390337259866L;
	
	private String description;
	private Long testId;
	private List<AlternativeInput> listAlternative;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class AlternativeInput{
		private String description;
		private Boolean correct;
	}
}