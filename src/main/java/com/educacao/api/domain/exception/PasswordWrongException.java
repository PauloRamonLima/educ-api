package com.educacao.api.domain.exception;

public class PasswordWrongException extends Exception {

	private static final long serialVersionUID = 4470890678197312561L;
	
	public PasswordWrongException(String message) {
		super(message);
	}
	

}
