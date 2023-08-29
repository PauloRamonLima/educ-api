package com.educacao.api.domain.services;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educacao.api.domain.exception.UserAlreadyRegistredException;
import com.educacao.api.domain.models.Student;
import com.educacao.api.domain.repositories.StudentRepository;
import com.educacao.api.dto.input.StudentSaveInput;
import com.educacao.api.dto.output.StudentListOutput;
import com.educacao.api.dto.output.StudentSaveOutput;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {
	
	private StudentRepository studentRepository;
	private ModelMapper modelMapper;
	
	@Transactional
	public StudentSaveOutput save(StudentSaveInput studentSaveInput) throws UserAlreadyRegistredException {
		Student student = modelMapper.map(studentSaveInput, Student.class);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate bornDate = LocalDate.parse(studentSaveInput.getBornDate().substring(0, 10), formatter);
		student.setBornDate(bornDate);
		student = studentRepository.save(student);
		student.setRegistration(generateRegistrationStudent(student.getId()));
		StudentSaveOutput studentSaveOutput = modelMapper.map(student, StudentSaveOutput.class);
		return studentSaveOutput;
	}
	
	public Page<StudentListOutput> pageStudent(int page, int size, String name, String registration){
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<Student> pageStudent = null;
		if(registration != null && !registration.isEmpty())
			pageStudent = studentRepository.findByRegistration(registration, pageable);
		else if(name != null && !name.isEmpty())
			pageStudent = studentRepository.findByNameContainingIgnoreCase(name, pageable); 
		else
			pageStudent = studentRepository.findAll(pageable);
		return pageStudent.map(student -> modelMapper.map(student, StudentListOutput.class));
	}
	
	public void delete(Long id) {
		studentRepository.deleteById(id);
	}
	
	private String generateRegistrationStudent(Long id) {
		int currentYear = Year.now().getValue();
		String formattedYear = String.format("%04d", currentYear);
		String formattedNumber = String.format("%04d", id);
		return formattedYear + formattedNumber;
	}
	
}
