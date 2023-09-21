package com.educacao.api.domain.models;

import java.io.Serializable;

import com.educacao.api.domain.models.enums.DayOfWeekEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_class_time_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassTimeTable implements Serializable {
	
	private static final long serialVersionUID = -3979054022584260137L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String dayOfWeek;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "day_of_week_ordinal")
	private DayOfWeekEnum dayOfWeekEnum;
	
	private String time;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subject", referencedColumnName = "id", nullable = false)
	private Subject subject;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_teacher", referencedColumnName = "id", nullable = false)
	private Teacher teacher;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", referencedColumnName = "id", nullable = false)
    private Class classTimeTable;
}