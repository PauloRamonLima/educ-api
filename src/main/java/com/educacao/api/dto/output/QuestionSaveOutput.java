package com.educacao.api.dto.output;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionSaveOutput implements Serializable {
	
	private static final long serialVersionUID = -7165242299097011077L;
	
	private String description;
	private Long testId;
	private String testDescription;
	private List<AlternativeOutput> listAlternative;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class AlternativeOutput{
		private String description;
		private Boolean correct;
	}
	
}
