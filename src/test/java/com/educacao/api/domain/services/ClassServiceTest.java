package com.educacao.api.domain.services;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.educacao.api.domain.repositories.ClassRepository;

@ExtendWith(MockitoExtension.class)
class ClassServiceTest {
	
	@Mock
	ClassRepository classRepository;
	
	@InjectMocks
	ClassService subject;

	@Test
	void mustReturnExceptionBecauseClassWithIdNotFound() {
		Long idClass = 1L;
		Mockito.when(classRepository.findById(idClass)).thenReturn(Optional.empty());
		Exception ex = Assertions.assertThrows(ClassNotFoundException.class, () -> subject.listStudents(idClass));
		Assertions.assertNotNull(ex);
	}

}
