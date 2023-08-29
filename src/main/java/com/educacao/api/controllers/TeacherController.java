package com.educacao.api.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educacao.api.domain.services.TeacherService;
import com.educacao.api.dto.input.TeacherSaveInput;
import com.educacao.api.dto.output.ErrorMessage;
import com.educacao.api.dto.output.TeacherListOutput;
import com.educacao.api.dto.output.TeacherSaveOutput;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("teacher")
@AllArgsConstructor
public class TeacherController {
	
	private TeacherService teacherService;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody TeacherSaveInput teacherSaveInput) {
		try {
			TeacherSaveOutput teacherSaveOutput = teacherService.save(teacherSaveInput);
			return ResponseEntity.ok(teacherSaveOutput);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(new ErrorMessage(e.getMessage()));
		}
	}
	
	@GetMapping
	public ResponseEntity<Page<TeacherListOutput>> page(
			@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String cpf){
		Page<TeacherListOutput> pageTeacher = teacherService.pageTeacher(page, size, name, cpf);
		return ResponseEntity.ok(pageTeacher);
	}

}