package com.educacao.api.domain.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.educacao.api.domain.exception.PasswordWrongException;
import com.educacao.api.domain.exception.UserNotFoundException;
import com.educacao.api.domain.repositories.UserRepository;
import com.educacao.api.dto.input.SavePasswordUserInput;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserService subject;
	
	@Test
	void mustReturnExceptionBecausePasswordNotEqual() {
		SavePasswordUserInput savePasswordUserInput = new SavePasswordUserInput();
		savePasswordUserInput.setPassword("123");
		savePasswordUserInput.setConfirmPassword("456");
		Exception ex = assertThrows(PasswordWrongException.class, () -> subject.savePasswordUser(savePasswordUserInput));
		assertNotNull(ex);
	}
	
	@Test
	void mustReturnExceptionBecauseEmailNotFound() {
		SavePasswordUserInput savePasswordUserInput = new SavePasswordUserInput();
		savePasswordUserInput.setPassword("123");
		savePasswordUserInput.setConfirmPassword("123");
		savePasswordUserInput.setEmail("teste@teste.com");
		Mockito.when(userRepository.findByEmail(savePasswordUserInput.getEmail())).thenReturn(null);
		Exception ex = assertThrows(UserNotFoundException.class, () -> subject.savePasswordUser(savePasswordUserInput));
		assertNotNull(ex);
	}

}
