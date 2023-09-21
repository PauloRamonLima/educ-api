package com.educacao.api.dto.output;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassTimeTableListOutput implements Serializable {
	
	private static final long serialVersionUID = 3319312971233077286L;
	
	private Long id;
	private String time;
	private String dayOfWeek;
	private String subjectName;
	private String teacherName;
	private String classTimeTableName;
}