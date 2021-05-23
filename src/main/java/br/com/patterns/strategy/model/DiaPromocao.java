package br.com.patterns.strategy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Entity
@EqualsAndHashCode(of = "id")
@Data
public class DiaPromocao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column	
	private String pratoDoDia;
	
	@Column	
	private Double valor;
	
	@Enumerated(EnumType.STRING)
	private DiaSemana diaSemana;
	
}
