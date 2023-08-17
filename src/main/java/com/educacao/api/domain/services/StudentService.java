package com.educacao.api.domain.services;

import java.time.Year;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educacao.api.domain.exception.UserAlreadyRegistredException;
import com.educacao.api.domain.models.Student;
import com.educacao.api.domain.models.enums.UserType;
import com.educacao.api.domain.repositories.StudentRepository;
import com.educacao.api.dto.input.StudentSaveInput;
import com.educacao.api.dto.output.StudentListOutput;
import com.educacao.api.dto.output.StudentSaveOutput;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {
	
	private StudentRepository studentRepository;
	private UserService userService;
	private ModelMapper modelMapper;
	
	@Transactional
	public StudentSaveOutput save(StudentSaveInput studentSaveInput) throws UserAlreadyRegistredException {
		Student student = modelMapper.map(studentSaveInput, Student.class);
		student = studentRepository.save(student);
		student.setRegistration(generateRegistrationStudent(student.getId()));
		StudentSaveOutput studentSaveOutput = modelMapper.map(student, StudentSaveOutput.class);
		return studentSaveOutput;
	}
	
	public Page<StudentListOutput> pageStudent(int page, int size){
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<Student> pageStudent = studentRepository.findAll(pageable);
		return pageStudent.map(student -> modelMapper.map(student, StudentListOutput.class));
	}
	
	private String generateRegistrationStudent(Long id) {
		int currentYear = Year.now().getValue();
		String formattedYear = String.format("%04d", currentYear);
		String formattedNumber = String.format("%04d", id);
		return formattedYear + formattedNumber;
	}
	
	private void saveUserStudent(String login) throws UserAlreadyRegistredException{
		userService.saveNewUser(login, UserType.STUDENT);
	}
	
}
