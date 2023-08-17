package com.educacao.api.domain.services;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educacao.api.domain.models.Alternative;
import com.educacao.api.domain.models.Question;
import com.educacao.api.domain.repositories.QuestionRepository;
import com.educacao.api.dto.input.QuestionSaveInput;
import com.educacao.api.dto.output.QuestionSaveOutput;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestionService {
	
	private QuestionRepository questionRepository;
	private ModelMapper modelMapper;
	
	@Transactional
	public QuestionSaveOutput save(QuestionSaveInput questionSaveInput) {
		Question question = modelMapper.map(questionSaveInput, Question.class);
		Type listType = new TypeToken<List<Alternative>>() {}.getType();
		List<Alternative> alternatives = modelMapper.map(questionSaveInput.getListAlternative(), listType);
		question.setListAlternatives(alternatives);
		question.setId(null);
		question = questionRepository.save(question);
		QuestionSaveOutput questionSaveOutput = modelMapper.map(question, QuestionSaveOutput.class);
		return questionSaveOutput;
	}
}