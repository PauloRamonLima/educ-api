package com.educacao.api.domain.services;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educacao.api.domain.models.Class;
import com.educacao.api.domain.models.Student;
import com.educacao.api.domain.repositories.ClassRepository;
import com.educacao.api.dto.input.ClassSaveInput;
import com.educacao.api.dto.output.ClassListOutput;
import com.educacao.api.dto.output.ClassSaveOutput;
import com.educacao.api.dto.output.ClassStudentsListOutput;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClassService {
	
	private ClassRepository classRepository;
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
	
	public List<ClassStudentsListOutput> listStudents(Long idClass) throws ClassNotFoundException{
		Optional<Class> classOptional = classRepository.findById(idClass);
		if(classOptional.isPresent()) {
			List<Student> listStudent = classOptional.get().getListStudent();
			Type listType = new TypeToken<List<ClassStudentsListOutput>>() {}.getType();
			List<ClassStudentsListOutput> list = modelMapper.map(listStudent, listType);
			Collections.sort(list, Comparator.comparing(ClassStudentsListOutput::getName));
			return list;
		}else {
			throw new ClassNotFoundException("Class with id: " + idClass + " not found");
		}
	}	
}
