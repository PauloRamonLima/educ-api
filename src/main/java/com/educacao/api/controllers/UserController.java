package com.educacao.api.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educacao.api.domain.services.UserService;
import com.educacao.api.dto.input.SavePasswordUserInput;
import com.educacao.api.dto.input.UserLoginInput;
import com.educacao.api.dto.input.UserSaveInput;
import com.educacao.api.dto.output.ErrorMessage;
import com.educacao.api.dto.output.UserOutput;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
	
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<Page<UserOutput>> page(
		@RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size){
		Page<UserOutput> pageUser = userService.page(page, size);
		return ResponseEntity.ok(pageUser);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody UserSaveInput userSaveInput){
		try {
			UserOutput userOutput = userService.save(userSaveInput);
			return ResponseEntity.ok(userOutput);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(new ErrorMessage(e.getMessage()));
		}
	}
	
	@PutMapping(path = "password")
	public ResponseEntity<?> savePassword(@RequestBody SavePasswordUserInput savePasswordUserInput){
		try {
			UserOutput userOutput = userService.savePasswordUser(savePasswordUserInput);
			return ResponseEntity.ok(userOutput);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(new ErrorMessage(e.getMessage()));
		}
	}
	
	@GetMapping(path = "login")
	public ResponseEntity<?> login(
			@RequestParam(defaultValue = "") String email,
			@RequestParam(defaultValue = "") String password){
		try {
			UserLoginInput userLoginInput = new UserLoginInput(email, password);
			UserOutput userOutput = userService.login(userLoginInput);
			return ResponseEntity.ok(userOutput);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(new ErrorMessage(e.getMessage()));
		}
		
	}

}
