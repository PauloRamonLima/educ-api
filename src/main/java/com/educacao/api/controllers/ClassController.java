package com.educacao.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educacao.api.domain.services.ClassService;
import com.educacao.api.dto.input.ClassSaveInput;
import com.educacao.api.dto.output.ClassListOutput;
import com.educacao.api.dto.output.ClassSaveOutput;
import com.educacao.api.dto.output.ClassStudentsListOutput;
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
	
	@GetMapping
	public ResponseEntity<List<ClassListOutput>> list(){
		List<ClassListOutput> classListOutput =  classService.list();
		return ResponseEntity.ok(classListOutput);
	}
	
	@GetMapping(path = "/students")
	public ResponseEntity<?> listStudentsClass(
			@RequestParam(defaultValue = "0") Long idClass){
		try {
			List<ClassStudentsListOutput> list = classService.listStudents(idClass);
			return ResponseEntity.ok(list);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(new ErrorMessage(e.getMessage()));
		}
	}

}
