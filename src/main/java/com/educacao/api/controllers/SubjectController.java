package com.educacao.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educacao.api.domain.services.SubjectService;
import com.educacao.api.dto.input.SubjectSaveInput;
import com.educacao.api.dto.output.ErrorMessage;
import com.educacao.api.dto.output.SubjectListOutput;
import com.educacao.api.dto.output.SubjectSaveOutput;

@RestController
@RequestMapping("/subject")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody SubjectSaveInput subjectSaveInput){
		try {
			SubjectSaveOutput subjectSaveOutput = subjectService.save(subjectSaveInput);
			return ResponseEntity.ok(subjectSaveOutput);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(new ErrorMessage(e.getMessage()));
		}
	}
	
	@GetMapping
	public ResponseEntity<List<SubjectListOutput>> listAll(){
		List<SubjectListOutput> list = subjectService.list();
		return ResponseEntity.ok(list);
	}
}