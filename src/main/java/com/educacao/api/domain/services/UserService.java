package com.educacao.api.domain.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.educacao.api.domain.exception.PasswordWrongException;
import com.educacao.api.domain.exception.UserAlreadyRegistredException;
import com.educacao.api.domain.exception.UserNotFoundException;
import com.educacao.api.domain.models.User;
import com.educacao.api.domain.repositories.UserRepository;
import com.educacao.api.dto.input.SavePasswordUserInput;
import com.educacao.api.dto.input.UserLoginInput;
import com.educacao.api.dto.input.UserSaveInput;
import com.educacao.api.dto.output.UserOutput;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Page<UserOutput> page(int page, int size){
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<User> pageUser = userRepository.findAll(pageable);
		return pageUser.map(user -> modelMapper.map(user, UserOutput.class));
	}
	
	public UserOutput save(UserSaveInput userSaveInput) throws UserAlreadyRegistredException {
		if(userSaveInput.getId() == null) {
			validateSaveUser(userSaveInput.getEmail());
		}
		User user = modelMapper.map(userSaveInput, User.class);
		userRepository.save(user);
		return modelMapper.map(user, UserOutput.class);
	}
	
	public UserOutput savePasswordUser(SavePasswordUserInput savePasswordUserInput) throws PasswordWrongException, UserNotFoundException {
		if(!savePasswordUserInput.getPassword().equals(savePasswordUserInput.getConfirmPassword()))
			throw new PasswordWrongException("Senhas informadas não correspondem!");
		User user = findByEmail(savePasswordUserInput.getEmail());
		if(user == null || user.getId() == null)
			throw new UserNotFoundException("Usuario com o email: " + savePasswordUserInput.getEmail() + " não encontrado!");
		user.setPassword(encryptPassword(savePasswordUserInput.getPassword()));
		userRepository.save(user);
		return modelMapper.map(user, UserOutput.class);
	}
	
	public UserOutput login(UserLoginInput userLoginInput) throws UserNotFoundException {
		User user = findByEmail(userLoginInput.getEmail());
		if(user == null || user.getId() == null || !verificarSenha(userLoginInput.getPassword(), user.getPassword())) {
			throw new UserNotFoundException("Usuario não encontrado");
		}else {
			return modelMapper.map(user, UserOutput.class);
		}
	}
	
	public boolean verificarSenha(String passwordLogin, String passwordUser) {
	    String passwordLoginEncripty = encryptPassword(passwordLogin);	    
	    return passwordLoginEncripty.equals(passwordUser);
	}
	
	private User findByEmail(String email) {
		User user = userRepository.findByEmail(email);
		return user;
	}
	
	private String encryptPassword(String password) {
		try {
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] encodedPassword = digest.digest(password.getBytes(StandardCharsets.UTF_8));
	        StringBuilder hexString = new StringBuilder();
	        for (byte b : encodedPassword) {
	            String hex = Integer.toHexString(0xff & b);
	            if (hex.length() == 1) {
	                hexString.append('0');
	            }
	            hexString.append(hex);
	        }
	        return hexString.toString();
	    } catch (NoSuchAlgorithmException e) {
	        return null;
	    }
	}
	
	private void validateSaveUser(String login) throws UserAlreadyRegistredException {
		User user = this.findByEmail(login);
		if(user != null && user.getId() != null)
			throw new UserAlreadyRegistredException("User with login: " + login + "already registered");
	}
}
