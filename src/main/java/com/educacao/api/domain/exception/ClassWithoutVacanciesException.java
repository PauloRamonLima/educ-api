package com.educacao.api.domain.exception;

public class ClassWithoutVacanciesException extends Exception {

	private static final long serialVersionUID = 1658451512478816896L;
	
	public ClassWithoutVacanciesException(String message) {
		super(message);
	}

}
