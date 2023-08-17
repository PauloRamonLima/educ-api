package com.educacao.api.domain.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educacao.api.domain.models.Class;
import com.educacao.api.domain.models.Subject;
import com.educacao.api.domain.models.Teacher;
import com.educacao.api.domain.models.Test;
import com.educacao.api.domain.repositories.TestRepository;
import com.educacao.api.dto.input.TestSaveInput;
import com.educacao.api.dto.output.TestSaveOutput;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TestService {
	
	private TestRepository testRepository;
	private ModelMapper modelMapper;
	
	@Transactional
	public TestSaveOutput save(TestSaveInput testSaveInput) {
		Test test = new Test();
		test.setDescription(testSaveInput.getDescription());
		test.setSubject(new Subject(testSaveInput.getSubjectId()));
		test.setTeacher(new Teacher(testSaveInput.getTeacherId()));
		test.setTestClass(new Class(testSaveInput.getTestClassId()));
		test = testRepository.save(test);
		return modelMapper.map(test, TestSaveOutput.class);
	}
	
}