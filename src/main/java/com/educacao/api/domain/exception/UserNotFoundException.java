package com.educacao.api.domain.exception;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 7483630339719575391L;
	
	public UserNotFoundException(String message) {
		super(message);
	}

}
