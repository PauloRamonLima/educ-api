package com.educacao.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educacao.api.domain.services.TeacherService;
import com.educacao.api.dto.input.TeacherSaveInput;
import com.educacao.api.dto.output.ErrorMessage;
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

}
