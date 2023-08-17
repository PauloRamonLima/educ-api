package com.educacao.api.domain.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educacao.api.domain.exception.UserAlreadyRegistredException;
import com.educacao.api.domain.models.Teacher;
import com.educacao.api.domain.models.enums.UserType;
import com.educacao.api.domain.repositories.TeacherRepository;
import com.educacao.api.dto.input.TeacherSaveInput;
import com.educacao.api.dto.output.TeacherSaveOutput;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeacherService {
	
	private TeacherRepository teacherRepository;
	private UserService userService;
	private ModelMapper modelMapper;	
	
	@Transactional
	public TeacherSaveOutput save(TeacherSaveInput teacherSaveInput) throws UserAlreadyRegistredException{
		saveUserStudent(teacherSaveInput.getCpf());
		Teacher teacher = modelMapper.map(teacherSaveInput, Teacher.class);
		teacherRepository.save(teacher);
		return modelMapper.map(teacher, TeacherSaveOutput.class);
	}
	
	private void saveUserStudent(String login) throws UserAlreadyRegistredException{
		userService.saveNewUser(login, UserType.TEACHER);
	}
}
