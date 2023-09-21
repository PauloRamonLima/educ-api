package com.educacao.api.dto.input;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassTimeTableSaveInput implements Serializable{
	
	private static final long serialVersionUID = -1036994257678544927L;
	private String time;
	private String dayOfWeek;
	private Long subjectId;
	private Long teacherId;
	private Long classTimeTableId;
}
