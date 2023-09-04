package com.educacao.api.domain.services;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educacao.api.domain.exception.UserAlreadyRegistredException;
import com.educacao.api.domain.models.Teacher;
import com.educacao.api.domain.models.enums.UserType;
import com.educacao.api.domain.repositories.TeacherRepository;
import com.educacao.api.dto.input.TeacherSaveInput;
import com.educacao.api.dto.output.TeacherListOutput;
import com.educacao.api.dto.output.TeacherSaveOutput;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeacherService {
	
	private TeacherRepository teacherRepository;
	private ModelMapper modelMapper;	
	
	@Transactional
	public TeacherSaveOutput save(TeacherSaveInput teacherSaveInput) throws UserAlreadyRegistredException{
		Teacher teacher = modelMapper.map(teacherSaveInput, Teacher.class);
		teacherRepository.save(teacher);
		return modelMapper.map(teacher, TeacherSaveOutput.class);
	}
	
	public Page<TeacherListOutput> pageTeacher(int page, int size, String name, String cpf){
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<Teacher> pageTeacher = null;
		if(cpf != null && !cpf.isEmpty())
			pageTeacher = teacherRepository.findByCpf(cpf, pageable);
		else if(name != null && !name.isEmpty())
			pageTeacher = teacherRepository.findByNameContainingIgnoreCase(name, pageable);
		else
			pageTeacher = teacherRepository.findAll(pageable);
		return pageTeacher.map(teacher -> modelMapper.map(teacher, TeacherListOutput.class));
	}
}
