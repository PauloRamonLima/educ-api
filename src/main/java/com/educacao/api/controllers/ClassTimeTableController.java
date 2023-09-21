package com.educacao.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educacao.api.domain.services.ClassTimeTableService;
import com.educacao.api.dto.input.ClassTimeTableSaveInput;
import com.educacao.api.dto.output.ClassTimeTableListOutput;
import com.educacao.api.dto.output.ClassTimeTableSaveOutput;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/class-time-table")
@AllArgsConstructor
public class ClassTimeTableController {
	
	private ClassTimeTableService classTimeTableService;
	
	@GetMapping
	public ResponseEntity<?> list(
			@RequestParam(defaultValue = "0") Long idClass){
		List<ClassTimeTableListOutput> list = classTimeTableService.list(idClass);
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody ClassTimeTableSaveInput classTimeTableSaveInput){
		ClassTimeTableSaveOutput classTimeTableSaveOutput = classTimeTableService.save(classTimeTableSaveInput);
		return ResponseEntity.ok(classTimeTableSaveOutput);
	}
}
