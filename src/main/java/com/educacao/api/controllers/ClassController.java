package com.educacao.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educacao.api.domain.services.ClassService;
import com.educacao.api.dto.input.ClassSaveInput;
import com.educacao.api.dto.output.ClassSaveOutput;
import com.educacao.api.dto.output.ErrorMessage;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/class")
@AllArgsConstructor
public class ClassController {
	
	private ClassService classService;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody ClassSaveInput classSaveInput){
		try {
			ClassSaveOutput classSaveOutput = classService.save(classSaveInput);
			return ResponseEntity.ok(classSaveOutput);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(new ErrorMessage(e.getMessage()));
		}
	}

}
