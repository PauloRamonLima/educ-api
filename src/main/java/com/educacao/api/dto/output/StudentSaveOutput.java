package com.educacao.api.dto.output;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSaveOutput implements Serializable {
	
	private static final long serialVersionUID = -6415630340427793161L;
	
	private String registration;
	private String name;
	private LocalDate bornDate;
	private String phoneNumber;
	private String className;
	private Long classId;
	private Long contactId;
}
