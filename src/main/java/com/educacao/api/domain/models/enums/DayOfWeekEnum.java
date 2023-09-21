package com.educacao.api.domain.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DayOfWeekEnum {
	
	SEGUNDA("Segunda"),
	TERCA("Terça"),
	QUARTA("Quarta"),
	QUINTA("Quinta"),
	SEXTA("Sexta"),
	SABADO("Sábado"),
	DOMINGO("Domingo");
	
	private String description;
}
