package com.educacao.api.domain.services;

import org.springframework.stereotype.Service;

import com.educacao.api.domain.exception.UserAlreadyRegistredException;
import com.educacao.api.domain.models.User;
import com.educacao.api.domain.models.enums.UserType;
import com.educacao.api.domain.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	
	private UserRepository userRepository;
	
	
	
	private void validateSaveUser(String login) throws UserAlreadyRegistredException {
		User user = userRepository.findByLogin(login);
		if(user != null && user.getId() != null)
			throw new UserAlreadyRegistredException("User with login: " + login + "already registered");
	}
}
