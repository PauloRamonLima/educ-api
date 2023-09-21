package com.educacao.api.dto.output;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClassTimeTableSaveOutput implements Serializable {
	
	private static final long serialVersionUID = -3208762585589299824L;
	
	private Long id;
	private String time;
	private String dayOfWeek;
	private Long subjectId;
	private Long teacherId;
}
