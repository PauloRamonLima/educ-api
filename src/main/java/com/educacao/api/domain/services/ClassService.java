package com.educacao.api.domain.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educacao.api.domain.models.Class;
import com.educacao.api.domain.repositories.ClassRepository;
import com.educacao.api.dto.input.ClassSaveInput;
import com.educacao.api.dto.output.ClassSaveOutput;

@Service
public class ClassService {
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Transactional
	public ClassSaveOutput save(ClassSaveInput classSaveInput) {
		Class classEntity = modelMapper.map(classSaveInput, Class.class);
		classEntity = classRepository.save(classEntity);
		ClassSaveOutput classSaveOutput = modelMapper.map(classEntity, ClassSaveOutput.class);
		return classSaveOutput;
	}
}
