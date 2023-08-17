package com.educacao.api.controllers;

import org.modelmapper.spi.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educacao.api.domain.services.TestService;
import com.educacao.api.dto.input.TestSaveInput;
import com.educacao.api.dto.output.TestSaveOutput;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("test")
@AllArgsConstructor
public class TestController {
	
	private TestService testService;
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody TestSaveInput testSaveInput){
		try {
			TestSaveOutput testSaveOutput = testService.save(testSaveInput);
			return ResponseEntity.ok(testSaveOutput);
		}catch(Exception e){
			return ResponseEntity.badRequest().body(new ErrorMessage(e.getMessage()));
		}
		
	}
}
