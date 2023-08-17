package com.educacao.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educacao.api.domain.services.QuestionService;
import com.educacao.api.dto.input.QuestionSaveInput;
import com.educacao.api.dto.output.QuestionSaveOutput;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("question")
@AllArgsConstructor
public class QuestionController {
	
	private QuestionService questionService;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody QuestionSaveInput questionSaveInput){
		QuestionSaveOutput questionSaveOutput = questionService.save(questionSaveInput);
		return ResponseEntity.ok(questionSaveOutput);
	}
}
