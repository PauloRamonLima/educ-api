package com.educacao.api.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educacao.api.domain.services.StudentService;
import com.educacao.api.dto.input.StudentSaveInput;
import com.educacao.api.dto.output.ErrorMessage;
import com.educacao.api.dto.output.StudentListOutput;
import com.educacao.api.dto.output.StudentSaveOutput;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("student")
@AllArgsConstructor
public class StudentController {
	
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody StudentSaveInput studentSaveInput){
		try {
			StudentSaveOutput studentSaveOutput = studentService.save(studentSaveInput);
			return ResponseEntity.ok(studentSaveOutput);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(new ErrorMessage(e.getMessage()));
		}
	}
	
	@GetMapping
	public ResponseEntity<Page<StudentListOutput>> list(
			@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
		Page<StudentListOutput> pageStudent = studentService.pageStudent(page, size);
		return ResponseEntity.ok(pageStudent);
	}
	
}