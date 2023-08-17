package com.educacao.api.domain.services;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educacao.api.domain.models.Subject;
import com.educacao.api.domain.repositories.SubjectRepository;
import com.educacao.api.dto.input.SubjectSaveInput;
import com.educacao.api.dto.output.SubjectListOutput;
import com.educacao.api.dto.output.SubjectSaveOutput;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubjectService {
	
	private SubjectRepository subjectRepository;
	private ModelMapper modelMapper;
	
	@Transactional
	public SubjectSaveOutput save(SubjectSaveInput subjectSaveInput) {
		Subject subject = modelMapper.map(subjectSaveInput, Subject.class);
		subject = subjectRepository.save(subject);
		SubjectSaveOutput subjectSaveOutput = modelMapper.map(subject, SubjectSaveOutput.class);
		return subjectSaveOutput;
	}
	
	public List<SubjectListOutput> list(){
		List<Subject> list = subjectRepository.findAll();
		Type listType = new TypeToken<List<SubjectListOutput>>() {}.getType();
		List<SubjectListOutput> listOutput = modelMapper.map(list, listType);
		return listOutput;
	}
	
}
