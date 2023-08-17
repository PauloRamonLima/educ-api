package com.educacao.api.domain.exception;

public class UserAlreadyRegistredException extends Exception {

	private static final long serialVersionUID = -8520476516722533555L;
	
	public UserAlreadyRegistredException(String message) {
		super(message);
	}
}
