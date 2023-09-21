package com.educacao.api.domain.services;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.educacao.api.domain.models.ClassTimeTable;
import com.educacao.api.domain.repositories.ClassTimeTableRepository;
import com.educacao.api.dto.input.ClassTimeTableSaveInput;
import com.educacao.api.dto.output.ClassListOutput;
import com.educacao.api.dto.output.ClassTimeTableListOutput;
import com.educacao.api.dto.output.ClassTimeTableSaveOutput;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClassTimeTableService {
	
	private ClassTimeTableRepository classTimeTableRepository;
	private ModelMapper modelMapper;
	
	public ClassTimeTableSaveOutput save(ClassTimeTableSaveInput classTimeTableSaveInput) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		ClassTimeTable classTimeTable = modelMapper.map(classTimeTableSaveInput, ClassTimeTable.class);
		classTimeTableRepository.save(classTimeTable);
		return modelMapper.map(classTimeTable, ClassTimeTableSaveOutput.class);
	}
	
	public List<ClassTimeTableListOutput> list(Long id){
		List<ClassTimeTable> list = classTimeTableRepository.findByClassTimeTableIdOrderByDayOfWeekEnumAscTimeAsc(id);
		Type listType = new TypeToken<List<ClassTimeTableListOutput>>() {}.getType();
		return modelMapper.map(list, listType);
		
	}

}