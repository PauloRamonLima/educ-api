package com.educacao.api.domain.services;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educacao.api.domain.models.Class;
import com.educacao.api.domain.repositories.ClassRepository;
import com.educacao.api.dto.input.ClassSaveInput;
import com.educacao.api.dto.output.ClassListOutput;
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
	
	public List<ClassListOutput> list(){
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		List<Class> listClass = classRepository.findAll(sort);
		Type listType = new TypeToken<List<ClassListOutput>>() {}.getType();
		List<ClassListOutput> listClassOutput = modelMapper.map(listClass, listType);
		return listClassOutput;
	}
}
