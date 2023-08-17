package com.educacao.api.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacao.api.domain.repositories.AlternativeRepository;

@Service
public class AlternativeService {
	
	@Autowired
	private AlternativeRepository alternativeRepository;
}
